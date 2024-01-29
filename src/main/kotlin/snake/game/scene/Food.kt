package snake.game.scene

import snake.graphics.basic.Color.GREEN
import snake.graphics.basic.Dimension
import snake.graphics.basic.Position
import snake.graphics.drawable.Rect

class Food(
    private val drawingArea: Rect
) : Rect() {

    init {
        moveToRandomLocation()
        dimension = Dimension(FOOD_SIZE, FOOD_SIZE)
        color = GREEN
    }

    private fun moveToRandomLocation() {
        val offset = 5

        position = Position(
            x = (drawingArea.minX + offset..drawingArea.maxX - offset - FOOD_SIZE).random(),
            y = (drawingArea.minY + offset..drawingArea.maxY - offset - FOOD_SIZE).random(),
        )
    }

    private companion object {
        private const val FOOD_SIZE = 7
    }
}
