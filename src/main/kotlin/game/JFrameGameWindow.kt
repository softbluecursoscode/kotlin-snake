package game

import javax.swing.JFrame

class JFrameGameWindow : JFrame() {

    init {
        setSize(400, 400)
        title = "Snake!"
        isResizable = false
        setLocationRelativeTo(null)
        defaultCloseOperation = EXIT_ON_CLOSE
        isVisible = true
    }
}
