fun main() {
    val nums = intArrayOf(3, 2, 2, 3)
    val `val` = 3

    println(removeElement(nums, `val`))
}

fun removeElement(nums: IntArray, `val`: Int): Int {
    var nval = 0
    val size = nums.size
    nums.forEachIndexed { index, n ->
        if (n == `val`) {
            nums[index] = -1
            nval++
        }
    }

    var j = 1
    nums.forEachIndexed { index, n ->
        if (n == -1 && j < nums.size) {
            while (nums[j] == -1) {
                j++
                if (j == nums.size)
                    break
            }
            if (j < nums.size) {
                nums[index] = nums[j]
                nums[j] = -1
            }
        }
        j++
    }

    (nums.forEach { print("$it ") })

    return size - nval
}