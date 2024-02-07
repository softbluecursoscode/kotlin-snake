package snake.config

data class GameConfig(
    val window: WindowConfig,
    val application: ApplicationConfig,
    val food: FoodConfig,
    val gameOver: GameOverConfig,
    val snake: SnakeConfig
)
