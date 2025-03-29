package blind75.array.twosum

fun main() {
    val numbers = intArrayOf(2, 3, 4)
    val target = 6

    twoSum2(numbers,target).forEach { println(it) }
}

fun twoSum2(numbers: IntArray, target: Int): IntArray {

    var start = 0
    var end = numbers.lastIndex
    var sum: Int

    while (start < end) {
        sum = numbers[start] + numbers[end]
        if (sum == target) {
            return intArrayOf(start, end)
        }
        if (sum > target)
            end--
        else start++
    }

    return intArrayOf()
}