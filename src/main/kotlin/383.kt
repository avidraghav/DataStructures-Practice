fun main() {
    val ransomNote = "aa"
    val magazine = "aab"
    println(canConstruct(ransomNote, magazine))
}

fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val map: MutableMap<Char, Int> = mutableMapOf()
    var result = true

    for (c in magazine) {
        if (map[c] == null)
            map[c] = 1
        else
            map[c] = map[c]!! + 1
    }

    for (c in ransomNote) {
        if (map[c] == null || map[c] == 0) {
            result = false
            break
        } else {
            map[c] = map[c]!! - 1
        }
    }
    return result
}
