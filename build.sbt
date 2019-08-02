name := "ChessEngine"

version := "0.1"

scalaVersion := "2.12.7"

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.13.4" % Test,
  "org.scalatest" % "scalatest_2.12" % "3.0.5" % Test,
  "org.scalamock" %% "scalamock" % "4.1.0" % Test
)