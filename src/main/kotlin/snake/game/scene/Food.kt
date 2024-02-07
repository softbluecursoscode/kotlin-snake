package snake.game.scene

import snake.config.FoodConfig
import snake.graphics.basic.Dimension
import snake.graphics.basic.Position
import snake.graphics.drawable.Rect

class Food(
    private val drawingArea: Rect,
    snake: Snake,
    private val foodConfig: FoodConfig
) : Rect() {

    var eatenTimes = 0
        private set

    init {
        moveToRandomLocation(snake)
        dimension = Dimension(foodConfig.sizeInPixels, foodConfig.sizeInPixels)
        color = foodConfig.color
    }

    fun eat(snake: Snake) {
        eatenTimes++
        moveToRandomLocation(snake)
    }

    private fun moveToRandomLocation(snake: Snake) {
        val offset = 5

        do {
            position = Position(
                x = (drawingArea.minX + offset..drawingArea.maxX - offset - foodConfig.sizeInPixels).random(),
                y = (drawingArea.minY + offset..drawingArea.maxY - offset - foodConfig.sizeInPixels).random(),
            )
        } while (snake.intersects(this))
    }
}
