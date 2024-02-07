package snake.game.core

import snake.config.GameConfig
import snake.config.loader.ConfigLoader.load
import snake.game.scene.Background
import snake.game.scene.Food
import snake.game.scene.GameOverText
import snake.game.scene.Snake
import snake.window.GameWindow
import snake.window.handler.Key.*
import java.lang.Thread.sleep

class Game {
    private lateinit var window: GameWindow
    private lateinit var snake: Snake
    private lateinit var food: Food
    private lateinit var gameConfig: GameConfig
    private var running = false

    fun start() {
        gameConfig = load()
        println("Configs: $gameConfig")

        window = GameWindow(
            title = gameConfig.window.title,
            width = gameConfig.window.width,
            height = gameConfig.window.height,
            minMillisBetweenKeyPressedEvents = gameConfig.application.minMillisBetweenKeyPressedEvents
        )

        addElementsToScreen()
        setupKeyPressedHandler()
        setupWindowClosedHandler()
        startGameLoop()
    }

    private fun addElementsToScreen() {
        window.addDrawable(
            Background(
                gameConfig.window.width,
                gameConfig.window.height,
                gameConfig.window.backgroundColor
            )
        )

        snake = Snake(gameConfig.snake)
        window.addDrawable(snake)

        food = Food(window.drawingArea, snake, gameConfig.food)
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
            sleep((MAX_SPEED - snake.speed.toLong()).coerceAtLeast(0))
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
        window.addDrawable(GameOverText(
            gameConfig.window.width,
            gameConfig.window.height,
            food.eatenTimes,
            gameConfig.gameOver
        ))
        window.update()
    }

    private val isGameOver: Boolean
        get() = !running || snake.collidedWithItself() || snake.collidedWithBounds(window.drawingArea)

    companion object {
        private const val MAX_SPEED = 50
    }
}
