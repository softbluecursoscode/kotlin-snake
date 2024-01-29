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

    init {
        val p = Position(200, 100)
        val d = Dimension(10, 10)

        var rect = Rect(p, d)
        addRect(rect)

        (1..10).forEach { _ ->
            rect = duplicateRect(rect, LEFT)
            addRect(rect)
        }

        //direction = RIGHT
    }

    fun move() {
        if (direction != NONE) {
            val head = firstRect
            Rect.shift(rects)

            val newHead = duplicateRect(head, direction)
            rects[0] = newHead
        }
    }
}