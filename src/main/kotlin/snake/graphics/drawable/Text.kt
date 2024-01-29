package snake.graphics.drawable

import snake.graphics.basic.Color
import snake.graphics.basic.Position
import java.awt.Graphics

open class Text(
    private val text: String,
    private val position: Position,
    color: Color
) : Drawable(color) {

    override fun draw(g: Graphics) {
        g.drawString(text, position.x, position.y)
    }
}
