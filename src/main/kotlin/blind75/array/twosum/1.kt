package blind75.array.twosum

fun main() {
    val nums = intArrayOf(3,2,4)
    twoSum(nums, 6).forEach { println(it) }
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = hashMapOf<Int, Int>()

    nums.forEachIndexed { i, num ->
        val complement = target - num
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }
        map[num] = i
    }

    return intArrayOf()
}


