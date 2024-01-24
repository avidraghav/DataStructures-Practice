fun main() {
    val nums = intArrayOf(1, 12, -5, -6, 50, 3)
    val k = 4
    println(findMaxAverage(nums, k))
}

/*
Time is greater than O(n) but less than O(n^2)
Better way is to use window sliding technique
 */

//fun findMaxAverage(nums: IntArray, k: Int): Double {
//    var i = 0
//    var j = i + k - 1
//    var sum = -Double.MAX_VALUE
//    var nsum = 0.00000
//
//    if (nums.size <= k) {
//        for (n in nums) {
//            nsum += n
//        }
//        return nsum / nums.size
//    } else {
//        while (j < nums.size) {
//            for (v in i..j) {
//                nsum += nums[v]
//            }
//            if (nsum > sum) {
//                sum = nsum
//            }
//            nsum = 0.00000
//            i++
//            j++
//        }
//        return (sum / k)
//    }
//}

// using sliding window
fun findMaxAverage(nums: IntArray, k: Int): Double {
    var i = 0
    var j = i + k - 1
    var sum = 0.00000
    var nsum = 0.00000

    if (nums.size <= k) {
        for (n in nums) {
            nsum += n
        }
        return nsum / nums.size
    } else {
        // O(k)
        for (n in i..j) {
            sum += nums[n]
        }
        nsum = sum
        i++
        j++
        // O(nums.size)
        while (j < nums.size) {
            nsum = nsum - nums[i - 1] + nums[j]
            if (nsum > sum) {
                sum = nsum
            }
            i++
            j++
        }
        return (sum / k)
    }
}