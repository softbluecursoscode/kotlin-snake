package snake.game.scene

import snake.graphics.basic.Color
import snake.graphics.drawable.Rect

class Background(
    width: Int,
    height: Int,
    color: Color
) : Rect(0, 0, width, height) {

    init {
        this.color = color
    }
}
