package blind75.array

fun main() {
    val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
    println(maxArea(height))
}


fun maxArea(height: IntArray): Int {
    var maxArea = 0
    var tempArea: Int
    var sH = 0
    var eH = 0

    var start = 0
    var end = height.lastIndex

    while (end > start) {
        sH = height[start]
        eH = height[end]
        tempArea = if (sH <= eH) {
            sH * (end - start)
        } else
            eH * (end - start)

        if (tempArea > maxArea)
            maxArea = tempArea

        if (sH < eH)
            start++
        else end--
    }

    return maxArea
}