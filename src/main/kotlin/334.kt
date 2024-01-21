fun main() {
    val nums = intArrayOf(20, 100, 10, 12, 5, 13)
    println(increasingTriplet(nums))
}

// indexes may not be consecutive
fun increasingTriplet(nums: IntArray): Boolean {
    if (nums.size < 3) return false
    var i = Int.MAX_VALUE
    var j = Int.MAX_VALUE

    nums.forEachIndexed { index, n ->
        if (n < i) {
            i = n
        } else if (n < j) {
            j = n
        } else {
            // we have found a number which is greater than previous two
            return true
        }
    }
    return false
}

