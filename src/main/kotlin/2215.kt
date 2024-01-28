fun main() {
//    val nums1 = intArrayOf(1, 2, 3)
//    val nums2 = intArrayOf(2, 4, 6)
    val nums1 = intArrayOf(1, 2, 3, 3)
    val nums2 = intArrayOf(1, 1, 2, 2)
    println(findDifference(nums1, nums2))
}

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val result: MutableList<List<Int>> = mutableListOf()
    val set1: MutableSet<Int> = mutableSetOf()
    val set2: MutableSet<Int> = mutableSetOf()

    for (n in nums1) {
        set1.add(n)
    }
    for (n in nums2) {
        set2.add(n)
    }

    val list1 = mutableListOf<Int>()
    for (k in set1) {
        if (set2.contains(k).not()) {
            list1.add(k)
        } else {
            set2.remove(k)
        }
    }
    result.add(list1)
    result.add(set2.toList())
    return result
}