forkInRun := true

libraryDependencies ++= Seq(
  "com.badlogicgames.gdx" % "gdx-backend-lwjgl" % LibgdxBuild.libgdxVersion,
  "com.badlogicgames.gdx" % "gdx-platform" % LibgdxBuild.libgdxVersion classifier "natives-desktop"
)
