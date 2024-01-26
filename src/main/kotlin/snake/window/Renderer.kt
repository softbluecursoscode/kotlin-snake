package snake.window

import snake.graphics.basic.Color
import snake.graphics.basic.Color.*
import snake.graphics.drawable.Drawable
import java.awt.Graphics

typealias AwtColor = java.awt.Color

class Renderer(
    //private val graphics: Graphics
) {
    private val drawables: MutableList<Drawable> = mutableListOf()

    fun render(graphics: Graphics) {
        drawables.forEach {
            graphics.color = toAwtColor(it.color)
            it.draw(graphics)
        }
    }

    fun add(drawable: Drawable) = drawables.add(drawable)

    fun remove(drawable: Drawable) = drawables.remove(drawable)

    private fun toAwtColor(color: Color): AwtColor {
        return when(color) {
            BLACK -> AwtColor.BLACK
            WHITE -> AwtColor.WHITE
            GREEN -> AwtColor.GREEN
            RED -> AwtColor.RED
            BLUE -> AwtColor.BLUE
        }
    }
}
