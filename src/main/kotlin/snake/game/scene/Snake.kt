package snake.game.scene

import snake.game.core.Direction
import snake.game.core.Direction.*
import snake.graphics.basic.Color.WHITE
import snake.graphics.basic.Dimension
import snake.graphics.basic.Position
import snake.graphics.drawable.Rect
import snake.graphics.drawable.Shape

class Snake : Shape(WHITE) {
    private var direction: Direction = NONE
    private var piecesToElongate = 0

    var speed = 0
        private set

    init {
        val p = Position(200, 100)
        val d = Dimension(PIECE_SIZE, PIECE_SIZE)

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

        if (headX <= areaX1 || headX + PIECE_SIZE >= areaX2) {
            collided = true
        }

        if (headY <= areaY1 || headY + PIECE_SIZE >= areaY2) {
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
        piecesToElongate = 5
    }

    private fun faster() {
        speed += 5
    }

    private companion object {
        private const val PIECE_SIZE = 10
    }
}