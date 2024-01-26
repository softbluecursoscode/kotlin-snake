package snake.window

import snake.graphics.drawable.Drawable

class GameWindow(
    title: String,
    width: Int,
    height: Int
) {
    private val window = JFrameGameWindow(title, width, height)

    fun addDrawable(drawable: Drawable) {
        window.renderer.add(drawable)
    }

    fun removeDrawable(drawable: Drawable) {
        window.renderer.remove(drawable)
    }
}