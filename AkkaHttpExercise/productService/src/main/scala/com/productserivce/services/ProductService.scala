package com.productserivce.services

import com.productserivce.persistence.Model.Product

import scala.concurrent.Future

trait ProductService {

  def create(product: Product): Future[ServiceResponse[Product]]
  def all(): Future[ServiceResponse[Seq[Product]]]

}
