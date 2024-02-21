fun main() {
    val nums = intArrayOf(0,0,1,1,1,2,2,3,3,4)
    println(removeDuplicates(nums))
}


fun removeDuplicates(nums: IntArray): Int {
    val map: MutableMap<Int, Int> = mutableMapOf()

    nums.forEach { num ->
        if (map[num] == null)
            map[num] = 1
        else
            map[num] = map[num]!! + 1
    }
    var i = 0
    for ((k, _) in map) {
        nums[i] = k
        i++
    }
    return map.size
}
