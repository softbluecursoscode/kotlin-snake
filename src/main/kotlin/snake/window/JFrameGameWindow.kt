package snake.window

import snake.graphics.drawable.Rect
import java.awt.Graphics
import javax.swing.JFrame

class JFrameGameWindow(
    title: String,
    width: Int,
    height: Int
) : JFrame() {
    val renderer: Renderer
    val drawingArea: Rect

    init {
        setSize(width, height)
        this.title = title
        isResizable = false
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE

        renderer = Renderer()
        isVisible = true

        val upperY = height - contentPane.size.height
        drawingArea = Rect(0, upperY, width, height - upperY)
    }

    override fun paint(g: Graphics) {
        renderer.render(g)
    }
}
