package snake.window

import snake.graphics.drawable.Rect
import java.awt.Graphics
import java.awt.Image
import javax.swing.JFrame

class JFrameGameWindow(
    title: String,
    width: Int,
    height: Int
) : JFrame() {
    private val buffer: Image
    private val imagePen: Graphics
    private var renderer: Renderer? = null
    val drawingArea: Rect

    init {
        setSize(width, height)
        this.title = title
        isResizable = false
        setLocationRelativeTo(null)
        defaultCloseOperation = DISPOSE_ON_CLOSE

        isVisible = true
        val upperY = height - contentPane.size.height
        drawingArea = Rect(0, upperY, width, height - upperY)

        buffer = createImage(width, height)
        imagePen = buffer.graphics
        renderer = Renderer(imagePen)
    }

    override fun paint(screenPen: Graphics) {
        if (renderer != null) {
            renderer!!.render()
            screenPen.drawImage(buffer, 0, 0, null)
        }
    }

    fun renderer() = renderer!!
}
