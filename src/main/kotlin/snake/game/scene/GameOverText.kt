package snake.game.scene

import snake.config.GameOverConfig
import snake.graphics.basic.Position
import snake.graphics.drawable.Text

class GameOverText(
    windowWith: Int,
    windowHeight: Int,
    score: Int,
    config: GameOverConfig
) : Text(
    text = String.format(config.textTemplate, score),
    position = Position(windowWith / 2 + config.positionOffset.x, windowHeight / 2 + config.positionOffset.y),
    color = config.color
)
