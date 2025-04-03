package blind75

fun main() {

    val nums = intArrayOf(1, 3, 5)
    val target = 5

    println(search(nums, target))
}

fun search(nums: IntArray, target: Int): Int {

    var start = 0
    var end = nums.lastIndex
    var mid = end / 2
    if (nums[mid] == target) return mid

    val left = (mid - 1).coerceAtLeast(0)
    val right = (mid + 1).coerceAtMost(nums.lastIndex)

    if (nums[mid] > nums[left]) {
        if (nums[0] < target && nums[mid]>target) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    } else {
        start = mid + 1
    }

    start = start.coerceIn(0..nums.lastIndex)
    end = end.coerceIn(0..nums.lastIndex)

    while (end - start > 1) {
        mid = (start + end) / 2
        if (nums[mid] == target) {
            return mid
        }
        if (nums[mid] > target) {
            end = mid
        } else {
            start = mid
        }
    }

    return when (target) {
        nums[start] -> start
        nums[end] -> end
        else -> -1
    }
}