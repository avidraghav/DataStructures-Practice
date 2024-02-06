import java.util.*
import kotlin.math.abs

fun main() {
   // val asteroids = intArrayOf(5, 10, -5)
    val asteroids = intArrayOf(8,-8)
    println(asteroidCollision(asteroids).contentToString())
}

fun asteroidCollision(asteroids: IntArray): IntArray {
    val stack = ArrayDeque<Int>()
    asteroids.forEachIndexed { _, asteroid ->
        // collision will keep happen
        var currentAsteroid = asteroid
        while (stack.peek() != null && stack.peek()!! > 0 && currentAsteroid < 0) {
            if (abs(stack.peek()!!) < abs(asteroid)) {
                stack.pop()
            } else if (abs(stack.peek()!!) == abs(asteroid)) {
                stack.pop()
                // currentAsteroid exploded
                currentAsteroid = 0
            } else {
                // currentAsteroid exploded
                currentAsteroid = 0
            }
        }
        if (currentAsteroid != 0)
            stack.push(currentAsteroid)
    }
    return stack.reversed().toIntArray()
}