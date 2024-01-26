package snake.graphics.drawable

import snake.graphics.basic.Color
import java.awt.Graphics

abstract class Drawable(var color: Color) {

    abstract fun draw(g: Graphics)
}