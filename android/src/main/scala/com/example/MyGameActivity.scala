package com.example

import android.os.Bundle
import com.example.core.MyGame
import com.badlogic.gdx.backends.android._

class MyGameActivity extends AndroidApplication {
  override def onCreate(savedInstanceState: Bundle): Unit = {
    super.onCreate(savedInstanceState)
    val cfg = new AndroidApplicationConfiguration
    initialize(new MyGame, cfg)
  }
}
