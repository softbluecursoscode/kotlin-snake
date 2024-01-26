package snake.graphics.drawable

import snake.graphics.basic.Color.BLACK
import snake.graphics.basic.Dimension
import snake.graphics.basic.Position
import java.awt.Graphics
import java.awt.Rectangle

class Rect(
    x: Int,
    y: Int,
    width: Int,
    height: Int
) : Drawable(BLACK) {

    private val rectangle = Rectangle(x, y, width, height)

    constructor(position: Position, dimension: Dimension) : this(position.x, position.y, dimension.width, dimension.height)

    var position: Position
        get() = Position(rectangle.x, rectangle.y)
        set(value) {
            rectangle.x = value.x
            rectangle.y = value.y
        }

    var dimension: Dimension
        get() = Dimension(rectangle.width, rectangle.height)
        set(value) {
            rectangle.width = value.width
            rectangle.height = value.height
        }

    val minX: Int
        get() = rectangle.minX.toInt()

    val minY: Int
        get() = rectangle.minY.toInt()

    val maxX: Int
        get() = rectangle.maxX.toInt()

    val maxY: Int
        get() = rectangle.maxY.toInt()

    fun intersects(rect: Rect) = rectangle.intersects(rect.rectangle)

    override fun draw(g: Graphics) {
        g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height)
    }
}
