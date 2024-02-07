package snake.game.scene

import snake.config.SnakeConfig
import snake.game.core.Direction
import snake.game.core.Direction.*
import snake.graphics.basic.Color.WHITE
import snake.graphics.basic.Dimension
import snake.graphics.basic.Position
import snake.graphics.drawable.Rect
import snake.graphics.drawable.Shape

class Snake(
    private val config: SnakeConfig
) : Shape(config.color) {
    private var direction: Direction = NONE
    private var piecesToElongate = 0

    var speed = config.incrementSpeed
        private set

    init {
        val p = Position(config.initialPosition.x, config.initialPosition.y)
        val d = Dimension(config.pieceSizeInPixels, config.pieceSizeInPixels)

        var rect = Rect(p, d)
        addRect(rect)

        (1..10).forEach { _ ->
            rect = duplicateRect(rect, LEFT)
            addRect(rect)
        }
    }

    fun move() {
        if (direction != NONE) {
            val head = firstRect
            val tail = lastRect
            Rect.shift(rects)

            val newHead = duplicateRect(head, direction)
            rects[0] = newHead

            if (piecesToElongate > 0) {
                rects.add(tail)
                piecesToElongate--
            }
        }
    }

    fun up() {
        if (direction.canChangeTo(UP)) {
            direction = UP
        }
    }

    fun down() {
        if (direction.canChangeTo(DOWN)) {
            direction = DOWN
        }
    }

    fun left() {
        if (direction.canChangeTo(LEFT)) {
            direction = LEFT
        }
    }

    fun right() {
        if (direction.canChangeTo(RIGHT)) {
            direction = RIGHT
        }
    }

    fun collidedWithItself(): Boolean {
        val head = firstRect
        return rects
            .drop(1)
            .any { head.intersects(it) }
    }

    fun collidedWithBounds(drawingArea: Rect): Boolean {
        var collided = false

        val head = firstRect
        val (headX, headY) = head.position

        val areaX1 = drawingArea.minX
        val areaX2 = drawingArea.maxX
        val areaY1 = drawingArea.minY
        val areaY2 = drawingArea.maxY

        if (headX <= areaX1 || headX + config.pieceSizeInPixels >= areaX2) {
            collided = true
        }

        if (headY <= areaY1 || headY + config.pieceSizeInPixels >= areaY2) {
            collided = true
        }

        return collided
    }

    fun eatIfFood(food: Food) {
        if (intersects(food)) {
            food.eat(this)
            elongate()
            faster()
        }
    }

    private fun elongate() {
        piecesToElongate = config.elongatePieces
    }

    private fun faster() {
        speed += config.incrementSpeed
    }
}