package snake.game.core

enum class Direction(
    val x: Int,
    val y: Int
) {
    NONE(0, 0),
    UP(0, -1),
    DOWN(0, 1),
    LEFT(-1, 0),
    RIGHT(1, 0);

    fun canChangeTo(other: Direction): Boolean {
        return !(x + other.x == 0 && y + other.y == 0)
    }
}
