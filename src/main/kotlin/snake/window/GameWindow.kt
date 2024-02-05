package snake.window

import snake.graphics.drawable.Drawable
import snake.graphics.drawable.Rect
import snake.window.handler.Key
import snake.window.handler.KeyHandler
import snake.window.handler.WindowHandler

class GameWindow(
    title: String,
    width: Int,
    height: Int
) {
    private val window = JFrameGameWindow(title, width, height)
    private val keyHandler = KeyHandler(window)
    private val windowHandler = WindowHandler(window)

    val drawingArea: Rect
        get() = window.drawingArea

    fun addDrawable(drawable: Drawable) {
        window.renderer().add(drawable)
    }

    fun removeDrawable(drawable: Drawable) {
        window.renderer().remove(drawable)
    }

    fun update() = window.repaint()

    fun onKeyPressed(keyPressedHandler: (Key) -> Unit) {
        keyHandler.defineKeyPressedHandler(keyPressedHandler)
    }

    fun onWindowClosed(windowClosedHandler: () -> Unit) {
        windowHandler.defineWindowClosedHandler(windowClosedHandler)
    }

    fun close() = window.dispose()
}