fun main() {
   // val s = "abcabcbb"
    val s = "dvdf"
    println(lengthOfLongestSubstring(s))
}

fun lengthOfLongestSubstring(s: String): Int {
    if (s.length == 1)
        return 1
    var length = 0
    var maxLength = 0
    val map = mutableMapOf<Char, Boolean>()
    var i = 0
    var j = i
    while (j < s.length) {
        if (map[s[j]] == null) {
            map[s[j]] = true
            length++
            j++
        } else {
            if (length > maxLength) {
                maxLength = length
            }
            map.clear()
            i++
            j = i
            length = 0
        }

    }
    return if (maxLength > length) return maxLength else length
}