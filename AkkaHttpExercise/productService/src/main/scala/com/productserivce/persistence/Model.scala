package com.productserivce.persistence

import akka.http.scaladsl.marshallers.sprayjson._
import com.productserivce.services.ErrorResponse
import spray.json.{DefaultJsonProtocol, DeserializationException, JsString, JsValue, JsonFormat}

import java.util.UUID

object Model extends SprayJsonSupport with DefaultJsonProtocol {

  implicit object uuidJsonFormat extends JsonFormat[UUID] {
    def write(uuid: UUID) = JsString(uuid.toString)

    def read(value: JsValue): UUID = {
      value match {
        case JsString(uuid) => UUID.fromString(uuid)
        case _ => throw new DeserializationException("Expected hexadecimal UUID string")
      }
    }
  }

  implicit val errorJsonFormat = jsonFormat2(ErrorResponse)
  implicit val productJsonFormat = jsonFormat5(Product)

  trait Entity { def id: UUID }

  case class Product(id: UUID, categoryId: String, productName: String, unitPrice: Int, unitsInStock: Int) extends  Entity

}
