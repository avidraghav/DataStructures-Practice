fun main() {
    val flowerbed = intArrayOf(0)
    val n = 1
    println(canPlaceFlowers(flowerbed, n))
    // 1 0 1 0 0 0 1 true
    // 1 0 1 0 1 0 1 true
}


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