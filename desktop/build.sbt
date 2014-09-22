import AssemblyKeys._

fork in run := true

libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl" % LibgdxBuild.libgdxVersion,
  "com.badlogicgames.gdx" % "gdx-platform" % LibgdxBuild.libgdxVersion classifier "natives-desktop"
)

assemblySettings

// Uncomment to set a name for the assembled jar
// jarName in assembly := "name.jar"
