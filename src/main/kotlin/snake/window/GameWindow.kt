package snake.window

import snake.graphics.drawable.Drawable
import snake.graphics.drawable.Rect

class GameWindow(
    title: String,
    width: Int,
    height: Int
) {
    private val window = JFrameGameWindow(title, width, height)

    val drawingArea: Rect
        get() = window.drawingArea

    fun addDrawable(drawable: Drawable) {
        window.renderer.add(drawable)
    }

    fun removeDrawable(drawable: Drawable) {
        window.renderer.remove(drawable)
    }

    fun update() = window.repaint()
}