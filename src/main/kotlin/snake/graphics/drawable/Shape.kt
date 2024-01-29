package snake.graphics.drawable

import snake.game.core.Direction
import snake.graphics.basic.Color
import snake.graphics.basic.Position
import java.awt.Graphics

open class Shape(color: Color) : Drawable(color) {
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

    fun duplicateRect(baseRect: Rect, direction: Direction): Rect {
        val (baseX, baseY) = baseRect.position
        val (baseWidth, baseHeight) = baseRect.dimension

        val p = Position(
            x = baseX + baseWidth * direction.x,
            y = baseY + baseHeight * direction.y
        )

        return Rect(p, baseRect.dimension)
    }
}