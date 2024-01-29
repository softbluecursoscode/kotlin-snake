package snake.game.scene

import snake.game.core.Game.Companion.WINDOW_HEIGHT
import snake.game.core.Game.Companion.WINDOW_WIDTH
import snake.graphics.basic.Color.RED
import snake.graphics.basic.Position
import snake.graphics.drawable.Text

class GameOverText(
    score: Int
) : Text(
    text = "Fim de Jogo! Sua pontuação foi: $score",
    position = Position(WINDOW_WIDTH / 2 - 90, WINDOW_HEIGHT / 2),
    color = RED
)
