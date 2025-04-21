package blind75.array.interview

fun main() {
    val intervals = arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))
    merge(intervals)
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.size == 1) return intervals
    var start = 0
    var end = start + 1
    val result = Array(intervals.size) { intArrayOf() }
    var i = 0

    while (start in intervals.indices && end in intervals.indices) {
        if (intervals[start][1] >= intervals[end][0] && intervals[end][1]>=intervals[start][0]) {
            val first = if (intervals[end][0] >= intervals[start][0]) {
                intervals[start][0]
            } else
                intervals[end][0]

            val second = if (intervals[end][1] > intervals[start][1]) {
                intervals[end][1]
            } else {
                intervals[start][1]
            }

            result[i] = intArrayOf(first, second)
            i++
        } else {
            result[i] = intArrayOf(intervals[start][0], intervals[start][1])
            i++
            result[i] = intArrayOf(intervals[end][0], intervals[end][1])
            i++
        }
        start += 2
        end = start + 1
    }

    return result.filter { it.isNotEmpty() }.toTypedArray()
}