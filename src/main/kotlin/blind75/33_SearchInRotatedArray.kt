package blind75

fun main() {

    val nums = intArrayOf(4, 5, 6, 7, 0, 1, 2)
    val target = 1

    println(search(nums, target))
}

fun search(nums: IntArray, target: Int): Int {

    var p1 = 0
    var p2 = p1 + 1
    var pivotIndex = -1

    while (p2 in nums.indices && p1 in nums.indices) {
        if (nums[p2] > nums[p1]) {
            p1++
            p2++
        } else {
            pivotIndex = p2
            break
        }
    }

    if (pivotIndex != -1) {
        if (target >= nums[pivotIndex] && target <= nums.last()) {
            p1 = pivotIndex
            p2 = nums.lastIndex
        } else {
            p1 = 0
            p2 = pivotIndex - 1
        }
    } else {
        p1 = 0
        p2 = nums.lastIndex
    }

    var mid = 0

    while (p1 <= p2) {
        mid = (p1 + p2) / 2
        if (nums[mid] == target)
            return mid

        if (nums[mid] < target) {
            p1 = mid + 1
        } else {
            p2 = mid - 1
        }
    }
    return -1
}