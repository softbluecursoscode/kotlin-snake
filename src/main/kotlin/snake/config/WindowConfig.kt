package snake.config

import snake.graphics.basic.Color

data class WindowConfig(
    val width: Int,
    val height: Int,
    val title: String,
    val backgroundColor: Color
)
