package snake.graphics.drawable

import snake.graphics.basic.Color
import java.awt.Graphics

class Shape(color: Color) : Drawable(color) {
    val rects = mutableListOf<Rect>()

    val firstRect: Rect
        get() = rects.first()

    val lastRect: Rect
        get() = rects.last()

    fun addRect(rect: Rect) {
        rect.color = color
        rects.add(rect)
    }

    fun intersects(other: Rect) = rects.any { it.intersects(other) }

    override fun draw(g: Graphics) {
        rects.forEach { it.draw(g) }
    }
}