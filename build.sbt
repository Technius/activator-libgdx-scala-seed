val projectName = """libgdx-scala-seed"""

name := projectName

scalaVersion in ThisBuild := "2.11.8"

val sharedSettings = Seq(
  libGdxVersion := "1.9.2",
  version := "1.0.0",
  javacOptions ++= Seq("-source", "1.7", "-target", "1.7"),
  scalacOptions ++= Seq("-target:jvm-1.7", "-deprecation", "-feature")
)

lazy val root = Project("root", file("."))
  .aggregate(android, desktop)

lazy val core = Project("core", file("core"))
  .settings(sharedSettings: _*)
  .settings(
    name := projectName + "-core",
    libraryDependencies += libGdx.value,
    exportJars := true
  )

lazy val android = Project("android", file("android"))
  .settings(sharedSettings: _*)
  .settings(
    name := projectName + "-android",
    platformTarget in Android := "android-23"
  )
  .dependsOn(core)
  .enablePlugins(LibGdxAndroid)

lazy val desktop = Project("desktop", file("desktop"))
  .settings(sharedSettings: _*)
  .settings(
    name := projectName + "-desktop",
    watchSources <++= sources in (core, Compile)
  )
  .dependsOn(core)
  .enablePlugins(LibGdxDesktop)

// Uncomment to generate a ".RUNNING_SBT" file when using desktop/run.
// This file will contain the path of the project directory.
// It can be detected using Gdx.files.internal(".RUNNING_SBT").exists
// This is useful for automatically enabling 'dev tools' when running.

// resourceGenerators in (desktop, Compile) += Def.task {
//   val file = baseDirectory.value / "desktop" / ".RUNNING_SBT"
//   IO.write(file, sys.props("user.dir"))
//   Seq(file)
// }.taskValue
