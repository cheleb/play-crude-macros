scalaVersion := "2.10.1"

organization := "net.orcades"

name := "play-crude-macros"

version := "0.0.1-SNAPSHOT"

libraryDependencies <+= (scalaVersion)("org.scala-lang" % "scala-reflect" % _)
