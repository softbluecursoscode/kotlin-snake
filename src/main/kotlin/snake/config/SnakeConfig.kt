package snake.config

import snake.config.model.XY
import snake.graphics.basic.Color

data class SnakeConfig(
    val initialPieces: Int,
    val pieceSizeInPixels: Int,
    val initialPosition: XY,
    val elongatePieces: Int,
    val color: Color,
    val initialSpeed: Int,
    val incrementSpeed: Int
)
