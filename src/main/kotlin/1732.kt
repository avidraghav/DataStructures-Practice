fun main() {
    val gain = intArrayOf(-5, 1, 5, 0, -7)
   // val gain = intArrayOf(-4,-3,-2,-1,4,3,2)
    println(largestAltitude(gain))
}

fun largestAltitude(gain: IntArray): Int {
    var highestAltitude = 0
    var max = 0
    for (g in gain) {
        highestAltitude += g
        if (highestAltitude > max) {
            max = highestAltitude
        }
    }
    return max
}