fun main() {
    val candies = intArrayOf(2,3,5,1,3)
    val extraCandies = 3

   // println(findKidWithMostCandiesInitially(candies))
    println( kidsWithCandies(candies, extraCandies))
}

fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
    val result = MutableList(candies.size) { true }

    val kidWithMostCandies = findKidWithMostCandiesInitially(candies)
    candies.forEachIndexed { index, candy ->
        if (candy + extraCandies < candies[kidWithMostCandies]) {
            result[index] = false
        }
    }
    return result
}

fun findKidWithMostCandiesInitially(candies: IntArray): Int {
    var kidWithMostCandies = 0
    candies.forEachIndexed { index, nCandies ->
        if (nCandies > candies[kidWithMostCandies]) {
            kidWithMostCandies = index
        }
    }
    return kidWithMostCandies
}






