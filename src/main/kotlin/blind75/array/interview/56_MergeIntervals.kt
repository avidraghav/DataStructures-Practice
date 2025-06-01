package blind75.array.interview

fun main() {
    val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(8, 10), intArrayOf(2, 6), intArrayOf(15, 18))
    merge(intervals)
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val result = mutableListOf<IntArray>()

    intervals.sortBy { it[0] }

    var current = intervals[0]

    for (i in 1 until intervals.size) {
        val next = intervals[i]

        if (next[0] <= current[1]) {
            // Merge the intervals
            current[1] = maxOf(current[1], next[1])
        } else {
            result.add(current)
            current = next
        }
    }
    result.add(current) // Don't forget to add the last interval

    return result.toTypedArray()
}
