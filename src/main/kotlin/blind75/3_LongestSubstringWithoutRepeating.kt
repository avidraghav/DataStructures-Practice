package blind75

fun main() {
    val s = "dvdf"
    println(lengthOfLongestSubstring(s))
}

fun lengthOfLongestSubstring(s: String): Int {
    var start = 0
    var end = 0
    val map = mutableMapOf<Char, Boolean>()
    var maxCount = Int.MIN_VALUE
    var tempCount = 0

    if (s.isEmpty()) return 0

    while (start in s.indices && end in s.indices) {
        if (map[s[end]] == null) {
            map[s[end]] = true
            tempCount++
            end++
        } else {
            map.clear()
            start++
            end = start
            tempCount = 0
        }
        maxCount = maxOf(maxCount, tempCount)
    }

    return maxCount
}