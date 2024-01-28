import kotlin.math.max

fun main() {
    val nums = intArrayOf(1,1,1,0,0,0,1,1,1,1,0)
    val k = 2
    println(longestOnes(nums,k))
}

fun longestOnes(nums: IntArray, k: Int): Int {
    var i = 0
    var j = 0
    var countZeroes = 0
    var ans = Int.MIN_VALUE
    while (j < nums.size) {
        if (nums[j] == 0) {
            countZeroes++
        }
        while (countZeroes > k) {
            if (nums[i] == 0) {
                countZeroes--
            }
            i++
        }
        ans = max(ans, j - i + 1)
        j++
    }
    return ans
}