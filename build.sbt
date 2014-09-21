name := """libgdx-scala-seed"""

version := "1.0"

scalaVersion := "2.11.2"

lazy val root = project in file(".") aggregate(android, desktop)

lazy val core = project in file("core")

lazy val android = project in file("android") dependsOn core

lazy val desktop = project in file("desktop") dependsOn core

libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx" % LibgdxBuild.libgdxVersion
)
