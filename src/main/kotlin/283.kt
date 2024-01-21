fun main() {
   // val nums = intArrayOf(0, 1, 0, 3, 12)
    val nums = intArrayOf(0)
    moveZeroes(nums)
}

fun moveZeroes(nums: IntArray) {
    var i = 0
    var nZeros = 0
    // using IntArray or arrayOf is essential because mutableList's size is not fixed even if the size is declared in the beginning
    nums.forEach {
        if (it == 0)
            nZeros++
    }
    nums.forEachIndexed { index, n ->
        if (n != 0) {
            nums[i] = n
            i++
        }
    }
    for (k in (nums.size - nZeros)..(nums.size - 1)) {
        nums[k] = 0
    }
}
