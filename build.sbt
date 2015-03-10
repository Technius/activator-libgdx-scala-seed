val projectName = """libgdx-scala-seed"""

name := projectName

version := "1.0.0"

scalaVersion in ThisBuild := "2.11.6"

lazy val root = Project("root", file("."))
  .aggregate(android, desktop)

lazy val core = Project("core", file("core"))
  .settings(
    name := projectName + "-core",
    libraryDependencies += libGdx
  )

lazy val android = Project("android", file("android"))
  .settings(name := projectName + "-android")
  .dependsOn(core)

lazy val desktop = Project("desktop", file("desktop"))
  .settings(
    name := projectName + "-desktop",
    watchSources <++= sources in (core, Compile)
  )
  .dependsOn(core)
  .enablePlugins(LibGdxDesktop)

javacOptions in Global ++= Seq("-source", "1.7", "-target", "1.7")

scalacOptions in Global += "-target:jvm-1.7"

// Uncomment to generate a ".RUNNING_SBT" file when using desktop/run.
// This file will contain the path of the project directory.
// It can be detected using Gdx.files.internal(".RUNNING_SBT").exists
// This is useful for automatically enabling 'dev tools' when running.

// resourceGenerators in (desktop, Compile) += Def.task {
//   val file = baseDirectory.value / "desktop" / ".RUNNING_SBT"
//   IO.write(file, sys.props("user.dir"))
//   Seq(file)
// }.taskValue
