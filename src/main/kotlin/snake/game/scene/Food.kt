package snake.game.scene

import snake.graphics.basic.Color.GREEN
import snake.graphics.basic.Dimension
import snake.graphics.basic.Position
import snake.graphics.drawable.Rect

class Food(
    private val drawingArea: Rect,
    snake: Snake
) : Rect() {

    var eatenTimes = 0
        private set

    init {
        moveToRandomLocation(snake)
        dimension = Dimension(FOOD_SIZE, FOOD_SIZE)
        color = GREEN
    }

    fun eat(snake: Snake) {
        eatenTimes++
        moveToRandomLocation(snake)
    }

    private fun moveToRandomLocation(snake: Snake) {
        val offset = 5

        do {
            position = Position(
                x = (drawingArea.minX + offset..drawingArea.maxX - offset - FOOD_SIZE).random(),
                y = (drawingArea.minY + offset..drawingArea.maxY - offset - FOOD_SIZE).random(),
            )
        } while (snake.intersects(this))
    }

    private companion object {
        private const val FOOD_SIZE = 7
    }
}
