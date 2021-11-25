version := "0.1"

lazy val akkaVersion = "2.6.17"
lazy val slickVersion = "3.3.2"
lazy val akkaHttpVersion = "10.2.7"

lazy val commonSettings = Seq(
  scalaVersion := "2.13.7",

  libraryDependencies ++= Seq(
    "org.scalactic" %% "scalactic" % "3.0.8",
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.scalatest" %% "scalatest" % "3.0.8" % Test,
    "com.softwaremill.macwire" %% "macros" % "2.3.2" % Provided
  )
)

lazy val databaseDependencies = Seq(
  "com.typesafe.slick" %% "slick" % slickVersion,
  "com.typesafe.slick" %% "slick-hikaricp" % slickVersion,
  "org.postgresql" % "postgresql" % "9.4-1206-jdbc42",
)

lazy val akkaDependencies = Seq(
  "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  "com.typesafe.akka" %% "akka-actor-typed" % akkaVersion,
  "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-stream-testkit" % akkaVersion % Test,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion % Test
)

lazy val productService = (project in file("productService"))
  .settings(
    name := "product-service",
    commonSettings,
    libraryDependencies ++= akkaDependencies ++ databaseDependencies
  )