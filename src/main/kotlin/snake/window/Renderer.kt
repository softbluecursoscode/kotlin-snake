package snake.window

import snake.graphics.basic.Color
import snake.graphics.basic.Color.*
import snake.graphics.drawable.Drawable
import java.awt.Graphics
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

typealias AwtColor = java.awt.Color

class Renderer(
    private val pen: Graphics
) {
    private val drawables: MutableList<Drawable> = mutableListOf()

    private val lock = ReentrantLock()

    fun render() {
        lock.withLock {
            drawables.forEach {
                pen.color = toAwtColor(it.color)
                it.draw(pen)
            }
        }
    }

    fun add(drawable: Drawable) = lock.withLock { drawables.add(drawable) }

    fun remove(drawable: Drawable) = lock.withLock { drawables.remove(drawable) }

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
