package snake.window.handler

import java.awt.event.*
import javax.swing.JFrame

class WindowHandler(
    private val owner: JFrame
) {

    private var currentWindowHandler: WindowListener? = null

    fun defineWindowClosedHandler(windowClosedHandler: () -> Unit) {
        owner.removeWindowListener(currentWindowHandler)

        currentWindowHandler = object : WindowAdapter() {
            override fun windowClosed(e: WindowEvent?) {
                windowClosedHandler()
            }
        }

        owner.addWindowListener(currentWindowHandler)
    }
}