fun main() {
    val nums = intArrayOf(0,0,1,1,1,1,2,3,3)
    println(removeDuplicates2(nums))
}

// with map
//fun removeDuplicates2(nums: IntArray): Int {
//
//    val map: MutableMap<Int, Int> = mutableMapOf()
//    nums.forEach { num ->
//        if (map[num] == null)
//            map[num] = 1
//        else
//            map[num] = map[num]!! + 1
//    }
//
//    var i = 0
//    var result = 0
//    for ((k, v) in map) {
//        if (v >= 2) {
//            repeat(2) {
//                nums[i] = k
//                i++
//                result++
//            }
//        } else {
//            nums[i] = k
//            i++
//            result++
//        }
//    }
//    return result
//}
// without map

fun removeDuplicates2(nums: IntArray): Int {

    var j = 1
    var present = false
    nums.forEachIndexed { index, num ->
        if (index == 0)
            return@forEachIndexed
        if (num == nums[index - 1] && !present) {
            nums[j] = num
            j++
            present = true
        }
        if (num != nums[index - 1]) {
            nums[j] = num
            j++
            present = false
        }
    }

    return j
}