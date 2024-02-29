fun main() {
    val nums = intArrayOf(-1, -100, 3, 99)
    val k = 2
    rotate(nums, k)
}

fun rotate(nums: IntArray, k: Int): Unit {
    val result = MutableList(nums.size) { 0 }

    nums.forEachIndexed { index, n ->
        if ((index + k) < nums.size) {
            result[index + k] = n
        } else {
            var place = (index + k) - nums.size
            if ((place) >= nums.size) {
                while (place >= nums.size) {
                    place -= nums.size
                }
            }
            result[place] = n
        }
    }
    result.forEachIndexed { index, i ->
        nums[index] = i
    }
}