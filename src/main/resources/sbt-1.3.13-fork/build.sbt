import scala.concurrent.duration._

scalaVersion := "2.13.4"
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % "2.6.8",
  "org.scalatest" %% "scalatest" % "3.0.8" % "test",
)
Test / fork := true
watchAntiEntropy := 0.millis
