import sbt.Keys.logBuffered

name := "sbt-example"
organization := "org.scalamacros"
version := "2.0.0"

scalaVersion in ThisBuild := "2.11.8"
run <<= run in Compile in core

lazy val macros = (project in file("macros")).settings(
  libraryDependencies += "org.scala-lang" % "scala-reflect" % scalaVersion.value
)

lazy val core = (project in file("core")).settings(
  libraryDependencies += "com.storm-enroute" %% "scalameter" % "0.8.2",
  testFrameworks += new TestFramework("org.scalameter.ScalaMeterFramework"),
  logBuffered := false,
  parallelExecution in Test := false
) dependsOn macros
