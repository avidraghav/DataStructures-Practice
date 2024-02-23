fun main() {
    val target = 6
    val nums = intArrayOf(10,2,3)
    println(minSubArrayLen(target, nums))
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var windowLength = Int.MAX_VALUE
    var i = 0
    var j = 0

    var sum: Int = nums[i]

    while (j < nums.size) {
        if (sum >= target) {
            val newWindowLength = j - i + 1
            if (newWindowLength == 1) {
                windowLength = newWindowLength
                break
            }
            if (newWindowLength < windowLength) {
                windowLength = newWindowLength
            }
            if (sum > target) {
                sum -= nums[i]
                i += 1
            } else {
                j += 1
                if (j < nums.size)
                    sum += nums[j]
            }
        } else {
            j += 1
            if (j < nums.size)
                sum += nums[j]
        }
    }


    return if (windowLength == Int.MAX_VALUE) 0 else windowLength
}