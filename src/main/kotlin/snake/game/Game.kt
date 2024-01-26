package snake.game

import snake.graphics.basic.Color
import snake.graphics.basic.Position
import snake.graphics.drawable.Rect
import snake.graphics.drawable.Text
import snake.window.GameWindow

class Game {

    fun start() {
        val window = GameWindow( "Snake!", 400, 400)

        window.addDrawable(Rect(0, 0, 400, 400))

        val square = Rect(100, 100, 90, 90)
        square.color = Color.BLUE
        window.addDrawable(square)

        window.addDrawable(Text("Hello!", Position(200, 300), Color.RED))
    }
}
