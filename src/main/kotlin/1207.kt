fun main() {
   // val arr = intArrayOf(1, 2, 2, 1, 1, 3)
    val arr = intArrayOf(1,2)
    println(uniqueOccurrences(arr))
}

fun uniqueOccurrences(arr: IntArray): Boolean {
    val map: MutableMap<Int, Int> = mutableMapOf()
    val set: MutableSet<Int> = mutableSetOf()

    for (n in arr) {
        if (map[n] == null) {
            map[n] = 0
            map[n] = map[n]!! + 1
        } else {
            map[n] = map[n]!! + 1
        }
    }

    for ((_, v) in map) {
        set.add(v)
    }

    return set.size == map.size
}