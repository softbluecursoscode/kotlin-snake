package snake.game.core

import snake.game.scene.Background
import snake.game.scene.Food
import snake.game.scene.GameOverText
import snake.game.scene.Snake
import snake.graphics.basic.Color.BLACK
import snake.window.GameWindow
import snake.window.handler.Key.*
import java.lang.Thread.sleep

class Game {
    private lateinit var window: GameWindow
    private lateinit var snake: Snake
    private lateinit var food: Food
    private var running = false

    fun start() {
        window = GameWindow(WINDOW_TITLE, WINDOW_WIDTH, WINDOW_HEIGHT)
        addElementsToScreen()
        setupKeyPressedHandler()
        setupWindowClosedHandler()
        startGameLoop()
    }

    private fun addElementsToScreen() {
        window.addDrawable(Background(WINDOW_WIDTH, WINDOW_HEIGHT, BLACK))

        snake = Snake()
        window.addDrawable(snake)

        food = Food(window.drawingArea, snake)
        window.addDrawable(food)
    }

    private fun setupKeyPressedHandler() {
        window.onKeyPressed { k ->
            println("Key Pressed: $k")
            when(k) {
                UP -> snake.up()
                DOWN -> snake.down()
                LEFT -> snake.left()
                RIGHT -> snake.right()
                ESC -> window.close()
            }
        }
    }

    private fun setupWindowClosedHandler() {
        window.onWindowClosed { running = false }
    }

    private fun startGameLoop() {
        running = true
        do {
            updateScene()
            sleep(MAX_SPEED - snake.speed.toLong())
        } while (!isGameOver)

        processGameOver()
        println("End of game")
    }

    private fun updateScene() {
        snake.move()
        snake.eatIfFood(food)
        window.update()
    }

    private fun processGameOver() {
        window.removeDrawable(snake)
        window.removeDrawable(food)
        window.addDrawable(GameOverText(food.eatenTimes))
        window.update()
    }

    private val isGameOver: Boolean
        get() = !running || snake.collidedWithItself() || snake.collidedWithBounds(window.drawingArea)

    companion object {
        const val WINDOW_WIDTH = 400
        const val WINDOW_HEIGHT = 400
        private const val WINDOW_TITLE = "Snake!"
        private const val MAX_SPEED = 50
    }
}
