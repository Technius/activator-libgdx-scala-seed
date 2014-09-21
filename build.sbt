val projectName = """libgdx-scala-seed"""

name := projectName

version := "1.0"

scalaVersion := "2.11.2"

lazy val root = project in file(".") aggregate(android, desktop)

lazy val core = Project(projectName + "-core", file("core"))

lazy val android = Project(projectName + "-android", file("android")) dependsOn core

lazy val desktop = Project(projectName + "-desktop", file("desktop")) dependsOn core

libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx" % LibgdxBuild.libgdxVersion
)
