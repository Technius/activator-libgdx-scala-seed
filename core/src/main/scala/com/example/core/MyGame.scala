package com.example.core

import com.badlogic.gdx.{ Game, Gdx, Screen }
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.{ BitmapFont, SpriteBatch }

class MyGame extends Game {
  override def create() = {
    setScreen(new MyGameScreen)
  }
}

class MyGameScreen extends Screen {
  val batch = new SpriteBatch()
  val font = new BitmapFont()

  override def render(deltaTime: Float) = {
    Gdx.graphics.getGL20.glClear(GL20.GL_COLOR_BUFFER_BIT)
    batch.begin()
    font.draw(batch, "Hello World!", 320, 240)
    batch.end()
  }

  override def dispose() = {
    batch.dispose()
    font.dispose()
  }

  override def resize(width: Int, height: Int) = Unit
  override def hide() = Unit
  override def show() = Unit
  override def pause() = Unit
  override def resume() = Unit
}
