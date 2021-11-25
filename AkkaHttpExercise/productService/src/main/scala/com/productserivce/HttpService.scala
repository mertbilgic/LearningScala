package com.productserivce

import akka.actor.ActorSystem
import akka.event.{Logging, LoggingAdapter}
import akka.http.scaladsl.Http
import akka.http.scaladsl.server.Route
import akka.stream.Materializer
import com.typesafe.config.Config

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}

class HttpService(config: Config, routes: Route)(implicit system: ActorSystem, materialize: Materializer) {

  implicit def executor: ExecutionContextExecutor = system.dispatcher
  val logger: LoggingAdapter = Logging(system, getClass)

  val bindingFuture: Future[Http.ServerBinding] =
    Http()
      .newServerAt(config.getString("http.interface"), config.getInt("http.port"))
      .bind(routes)

  bindingFuture.onComplete {
    case Success(bound) =>
      logger.info(s"Server Started: ${bound.localAddress.getHostString}")
    case Failure(e) =>
      logger.error(s"Server could not start: ${e.getMessage}")
      system.terminate()
  }
}

object HttpService {

  def run(config: Config, serviceRoutes: Route)(implicit system: ActorSystem, materialize: Materializer) =
    new HttpService(config, serviceRoutes)
}