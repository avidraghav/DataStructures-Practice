fun main() {
    val nums = intArrayOf(1, 7, 3, 6, 5, 6)
   //  val nums = intArrayOf(1,2,3)
   // val nums = intArrayOf(2, -1, 1)
    println(pivotIndex(nums))
}
// sliding window O(n)
fun pivotIndex(nums: IntArray): Int {
    var pivot = -1
    var leftSum = 0
    var rightSum = 0
    for (n in nums) {
        rightSum += n
    }
    rightSum -= nums[0]
    nums.forEachIndexed { index, n ->
        if (leftSum == rightSum) {
            pivot = index
            return pivot
        }
        leftSum += n
        if (index + 1 != nums.size)
            rightSum -= nums[index + 1]
        else
            rightSum = 0
    }
    return pivot
}

// O(n^2)
//fun pivotIndex(nums: IntArray): Int {
//    var pivot = -1
//
//    nums.forEachIndexed { index, n ->
//        if (calculateLeftSum(index, nums) == calculateRightSum(index, nums)) {
//            pivot = index
//            return@forEachIndexed
//        }
//    }
//    return pivot
//}
//
//fun calculateLeftSum(index: Int, nums: IntArray): Int {
//    var sum: Int = 0
//    if (index == 0)
//        sum = 0
//    else {
//        for (i in 0 until index) {
//            sum += nums[i]
//        }
//    }
//    return sum
//}
//
//fun calculateRightSum(index: Int, nums: IntArray): Int {
//    var sum: Int = 0
//    if (index == nums.size - 1) {
//        sum = 0
//    } else {
//        for (i in index + 1 until nums.size) {
//            sum += nums[i]
//        }
//    }
//    return sum
//}
