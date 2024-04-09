fun main() {
    val nums = intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6)
    val k = 4
    println(findKthLargest(nums, k))
}

fun findKthLargest(nums: IntArray, k: Int): Int {
    val heapifiedArray = maxHeapify(nums)
    return deleteKTimes(heapifiedArray, k)
}

private fun maxHeapify(nums: IntArray): IntArray {
    var i = 1
    var j = i
    while (i < nums.size) {
        while (j > 0 && nums[j] > nums[j / 2]) {
            val temp = nums[j]
            nums[j] = nums[j / 2]
            nums[j / 2] = temp
            j = j / 2
        }
        i++
        j = i
    }

    return nums

}

private fun deleteKTimes(heapifiedArray: IntArray, k: Int): Int {
    var result = 0
    var l = 1
    var m = 0
    var temp = 0
    repeat(k) {
        result = heapifiedArray[0]
        heapifiedArray[0] = heapifiedArray[heapifiedArray.lastIndex - m]
        var i = 1
        var j = i
        while (i < (heapifiedArray.size - l)) {
            while (j > 0 && heapifiedArray[j] > heapifiedArray[j / 2]) {
                temp = heapifiedArray[j]
                heapifiedArray[j] = heapifiedArray[j / 2]
                heapifiedArray[j / 2] = temp
                j = j / 2
            }
            i++
            j = i
        }
        l++
        m++
    }
    return result
}
