import kotlin.math.absoluteValue

fun main() {
    val nums = intArrayOf(2,3,1,1,4)
    println(canJump(nums))
}

fun canJump(nums: IntArray): Boolean {
    var target = nums.lastIndex
    var i = nums.lastIndex - 1

    while (i >= 0) {
        if (nums[i] >= (target - i).absoluteValue) {
            target = i
        }
        i--
    }
    return target == 0
}