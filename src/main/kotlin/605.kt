fun main() {
    val flowerbed = intArrayOf(0)
    val n = 1
    println(canPlaceFlowers(flowerbed, n))

}

// todo: can be done with O(n) complexity by creating a new
// array which has 0 at the beginning and end so the size of that
// array will be flowerbed+2
// we will iterate through the original values in the array
// and use the usual logic to check for insertion (see 3rd if)
// if insertion takes place we decrement n and after the iteration
// over the array is completed and n=0 then all were inserted otherwise not
fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {

    if (flowerbed.size == 1) {
        return if(flowerbed[0] == 0)
            true
        else{
            n==0
        }
    }

    var canPlaceFlowers = true
    repeat(n) {
        flowerbed.forEachIndexed { index, _ ->
            if (index == 0 && flowerbed[index] == 0 && flowerbed[1] == 0) {
                flowerbed[index] = 1
                canPlaceFlowers = true
                return@repeat
            }
            if (index == flowerbed.size - 1 && flowerbed[index] == 0 && flowerbed[index - 1] == 0) {
                flowerbed[index] = 1
                canPlaceFlowers = true
                return@repeat
            }
            if (index > 0 && flowerbed[index] == 0 && flowerbed[index - 1] == 0 && flowerbed[index + 1] == 0) {
                flowerbed[index] = 1
                canPlaceFlowers = true
                return@repeat
            }
            canPlaceFlowers = false
        }
    }
    return canPlaceFlowers
}