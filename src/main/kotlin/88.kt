fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    val m = 3
    val nums2 = intArrayOf(2, 5, 6)
    println(merge(nums1, m, nums2, nums2.size))
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    var i = 0

    while (i != m) {
        i++
    }

    for (n2 in nums2) {
        nums1[i] = n2
        i++
    }
    nums1.forEach {
        print("$it ")
    }
    println()
    i = 0
    var j = 1

    while (i < m + n) {
        while (j < m + n) {
            if (nums1[i] > nums1[j]) {
                val temp = nums1[i]
                nums1[i] = nums1[j]
                nums1[j] = temp
            }
            j++
        }
        i++
        j= i+1
    }
    nums1.forEach {
        print("$it ")
    }

}