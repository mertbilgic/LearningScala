package com.productserivce

import akka.actor.ActorSystem
import akka.http.scaladsl.server.Route
import akka.stream.Materializer
import com.productserivce.routes.ProductRoutes
import com.productserivce.services.{ProductService, ProductServiceImpl}
import com.typesafe.config.{Config, ConfigFactory}

object Server extends App {

  implicit val system: ActorSystem = ActorSystem()
  implicit val materialize: Materializer = Materializer(system)

  def config: Config = ConfigFactory.load()

  lazy val productService   = new ProductServiceImpl()
  lazy val productRoute   = new ProductRoutes(productService)

  val serviceRoutes: Route = productRoute.route

  HttpService.run(config, serviceRoutes)

}
