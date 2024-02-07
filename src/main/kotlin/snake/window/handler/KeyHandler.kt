package snake.window.handler

import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import java.awt.event.KeyEvent.*
import java.awt.event.KeyListener
import java.time.Instant
import java.time.Instant.EPOCH
import javax.swing.JFrame

class KeyHandler(
    private val owner: JFrame,
    private val minMillisBetweenKeyPressedEvents: Int,
) {

    private var currentKeyHandler: KeyListener? = null
    private var lastKeyboardEventTime = EPOCH

    fun defineKeyPressedHandler(keyPressedHandler: (Key) -> Unit) {
        owner.removeKeyListener(currentKeyHandler)

        currentKeyHandler = object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent) {
                val now = Instant.now()

                if (lastKeyboardEventTime.plusMillis(minMillisBetweenKeyPressedEvents.toLong()).isBefore(now)) {
                    val key = fromAwtKey(e.keyCode)

                    if (key != null) {
                        keyPressedHandler(key)
                        lastKeyboardEventTime = now
                    }
                }
            }
        }

        owner.addKeyListener(currentKeyHandler)
    }

    private fun fromAwtKey(keyCode: Int): Key? {
        return when(keyCode) {
            VK_UP -> Key.UP
            VK_DOWN -> Key.DOWN
            VK_LEFT -> Key.LEFT
            VK_RIGHT -> Key.RIGHT
            VK_ESCAPE -> Key.ESC
            else -> null
        }
    }
}