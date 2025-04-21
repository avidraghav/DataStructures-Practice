package blind75

fun main() {

}

fun findMin(nums: IntArray): Int {
    if (nums.size == 1) return nums.first()

    var p1 = 0
    var p2 = p1 + 1
    var pivot = nums[0]

    while (p2 in nums.indices && p1 in nums.indices) {
        if (nums[p2] > nums[p1]) {
            p1++
            p2++
        } else {
            pivot = nums[p2]
            break
        }
    }

    return pivot
}