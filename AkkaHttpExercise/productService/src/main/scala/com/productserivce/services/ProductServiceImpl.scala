package com.productserivce.services
import com.productserivce.persistence.Model.Product
import com.typesafe.sslconfig.ssl.FakeChainedKeyStore.User
import org.slf4j.{Logger, LoggerFactory}

import java.util.UUID
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

class ProductServiceImpl extends ProductService {

  private val logger: Logger = LoggerFactory.getLogger(getClass.getName)
  private var Products = Map[UUID, Product]()

  override def create(product: Product): Future[ServiceResponse[Product]] = Future {
    logger.info(s"[create] - ${product.id}")
    Try(Products + (product.id -> product)).map(updated => Products = updated) match {
      case Failure(exception) => Left(ErrorResponse(exception.getMessage,0))
      case Success(_) => Right(product)
    }
  }

  override def all(): Future[ServiceResponse[Seq[Product]]] = Future {
    logger.info("[all]")

    Try(Products.values) match {
      case Failure (exception) => Left(ErrorResponse(exception.getMessage,0))
      case Success(empty) if empty.isEmpty => Right(empty.toList)
      case Success(nonEmpty) => Right(nonEmpty.toList)
    }

  }
}
