val projectName = """libgdx-scala-seed"""

name := projectName

version := "1.0"

scalaVersion := "2.11.2"

lazy val root = project in file(".") aggregate(android, desktop)

lazy val core = Project("core", file("core")) settings(name := projectName + "-core")

lazy val android = Project("android", file("android")) settings(name := projectName + "-android") dependsOn core

lazy val desktop = Project("desktop", file("desktop")) settings(name := projectName + "-desktop") dependsOn core

libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx" % LibgdxBuild.libgdxVersion
)
