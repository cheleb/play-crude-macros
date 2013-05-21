scalaVersion := "2.10.1"

organization := "net.orcades"

name := "play-crude-macros"

version := "0.0.1-SNAPSHOT"

libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _)

libraryDependencies += "play" %% "play" % "2.1.0"
