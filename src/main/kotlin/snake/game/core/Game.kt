package snake.game.core

import snake.game.scene.Background
import snake.game.scene.Food
import snake.game.scene.Snake
import snake.graphics.basic.Color.BLACK
import snake.window.GameWindow
import java.lang.Thread.sleep

class Game {
    private lateinit var window: GameWindow
    private lateinit var snake: Snake

    fun start() {
        window = GameWindow(WINDOW_TITLE, WINDOW_WIDTH, WINDOW_HEIGHT)
        addElementsToScreen()
        startGameLoop()
    }

    private fun addElementsToScreen() {
        window.addDrawable(Background(WINDOW_WIDTH, WINDOW_HEIGHT, BLACK))
        window.addDrawable(Food(window.drawingArea))

        snake = Snake()
        window.addDrawable(snake)

        //window.addDrawable(GameOverText(10))
    }

    private fun startGameLoop() {
        do {
            updateScene()
            sleep(50)
        } while (!isGameOver)
    }

    private fun updateScene() {
        snake.move()
        window.update()
    }

    private val isGameOver: Boolean
        get() = false

    companion object {
        const val WINDOW_WIDTH = 400
        const val WINDOW_HEIGHT = 400
        private const val WINDOW_TITLE = "Snake!"
    }
}
