# libGDX Scala Seed
This is a Typesafe Activator seed that generates a barebones [libGDX](http://libgdx.badlogicgames.com/) project. The generated project uses Scala.

This is currently a work-in-progress.

# Usage
Use Typesafe Activator to create a project based on this template. Edit the project name in `build.sbt`.

Put all the needed assets in `core/src/main/resources`.

* Generate Eclipse project files with `activator eclipse`.
* Run the application on your computer using `activator desktop/run`.
* Create a zip file of the desktop build by running `activator desktop/universal:packageBin`.

# TODO
* Implement Android project generation
* Improve asset handling
* Fix the line ending problems
* Address LWJGL issues after desktop/run
