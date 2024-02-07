package snake.config

import snake.config.model.XY
import snake.graphics.basic.Color

data class GameOverConfig(
    val textTemplate: String,
    val color: Color,
    val positionOffset: XY
)
