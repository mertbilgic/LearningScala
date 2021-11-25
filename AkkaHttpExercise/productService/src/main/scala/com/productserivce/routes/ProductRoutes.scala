package com.productserivce.routes

import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route
import com.productserivce.persistence.Model._
import com.productserivce.services.ProductService
import org.slf4j.{Logger, LoggerFactory}

class ProductRoutes(productService: ProductService) {
  val logger: Logger = LoggerFactory.getLogger(getClass)
  final val productAPI = "product"

  val route: Route =
    pathPrefix(productAPI) {
      concat(
        pathEndOrSingleSlash {
          concat(
            get {
              logger.info("GET all request for product")
              complete(productService.all)
            },
            (post & entity(as[Product])) { product =>
              logger.info("POST request for create product with id {}", product.id)
              complete(productService.create(product))
            }
          )
        },
        path("hello") {
          get {
            complete(HttpEntity(ContentTypes.`text/html(UTF-8)`, "<h1>Say hello to akka-http</h1>"))
          }
        }
      )
    }
}

