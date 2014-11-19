import com.typesafe.sbt.SbtNativePackager._

import NativePackagerKeys._

val projectName = """libgdx-scala-seed"""

name := projectName

version := "1.0"

scalaVersion in ThisBuild := "2.11.2"

libraryDependencies in ThisBuild ++= Seq(
  "com.badlogicgames.gdx" % "gdx" % LibgdxBuild.libgdxVersion
)

javacOptions in ThisBuild ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions in ThisBuild += "-target:jvm-1.7"

lazy val root = project in file(".") aggregate(android, desktop)

lazy val core = Project("core", file("core")) settings(name := projectName + "-core")

lazy val android = Project("android", file("android")) settings(name := projectName + "-android") dependsOn core

lazy val desktop = Project("desktop", file("desktop")) settings(name := projectName + "-desktop") dependsOn core

unmanagedResourceDirectories in (desktop, Compile) += baseDirectory.value / "assets"

mappings in (desktop, Compile, packageBin) ~= { _.filter(_._1.getName.endsWith(".class")) }

mappings in Universal in desktop ++= {
  val a = (baseDirectory.value / "assets").*** pair relativeTo(baseDirectory.value)
  a map (t => (t._1, t._2.replaceFirst("assets", "bin")))
}

// Uncomment to generate a ".RUNNING_SBT" file when using desktop/run.
// This file will contain the path of the project directory.
// It can be detected using Gdx.files.internal(".RUNNING_SBT").exists
// This is useful for automatically enabling 'dev tools' when running.

// resourceGenerators in (desktop, Compile) += Def.task {
//   val file = baseDirectory.value / "desktop" / ".RUNNING_SBT"
//   IO.write(file, sys.props("user.dir"))
//   Seq(file)
// }.taskValue
