package com.example

import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.example.core.MyGame

object MyDesktopApplication {
  def main(args: Array[String]) {
    val cfg = new LwjglApplicationConfiguration
    new LwjglApplication(new MyGame, cfg)
  }
}
