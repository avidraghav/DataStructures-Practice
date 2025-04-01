package blind75.array.interview

fun main() {
    // val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    val nums = intArrayOf(-1, -2)
    println(maxSubArray(nums))
}

fun maxSubArray(nums: IntArray): Int {

    var subArraySum: Int
    var maxSum: Int
    var start = 0
    var end = start

    if (nums.size == 1)
        return nums[0]

    subArraySum = nums[start]
    maxSum = subArraySum

    while (start in nums.indices && end in nums.indices) {
        if (subArraySum >= 0) {
            end++
            if (end in nums.indices)
                subArraySum += nums[end]
        } else {
            start++
            end = start
            subArraySum = if (start in nums.indices) nums[start] else subArraySum
        }

        if (subArraySum > maxSum) {
            maxSum = subArraySum
        }
    }

    return maxSum
}
