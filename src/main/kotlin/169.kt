fun main() {
    val nums = intArrayOf(2,2,1,1,1,2,2)
    println(majorityElement(nums))
}

fun majorityElement(nums: IntArray): Int {
    var res = nums[0]
    var frequency = 0

    for (n in nums) {
        if (n == res)
            frequency++
        else {
            if (frequency == 0) {
                res = n
                frequency++
            } else
                frequency--
        }
    }
    return res
}