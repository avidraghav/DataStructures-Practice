fun main() {
//    val word1 = "abc"
//    val word2 = "bca"
//    val word1 = "a"
//    val word2 = "aa"
//    val word1 = "cabbba"
//    val word2 = "abbccc"
    val word1 = "aaabbbbccddeeeeefffff"
    val word2 = "aaaaabbcccdddeeeeffff"
    println(closeStrings(word1, word2))
}

fun closeStrings(word1: String, word2: String): Boolean {
    if (word1.length != word2.length)
        return false
    else {
        var set1: MutableSet<Char>? = mutableSetOf()
        var set2: MutableSet<Char>? = mutableSetOf()
        for (c in word1) {
            set1?.add(c)
        }
        for (c in word2) {
            set2?.add(c)
        }
        if (set1 != set2)
            return false
        else {
            set1 = null
            set2 = null
            val map1: MutableMap<Char, Int> = mutableMapOf()
            val map2: MutableMap<Char, Int> = mutableMapOf()

            val map3: MutableMap<Int, Int> = mutableMapOf()
            val map4: MutableMap<Int, Int> = mutableMapOf()
            for (c in word1) {
                if (map1[c] == null) {
                    map1[c] = 0
                }
                map1[c] = map1[c]!! + 1
            }

            for (c in word2) {
                if (map2[c] == null) {
                    map2[c] = 0
                }
                map2[c] = map2[c]!! + 1
            }

            for ((_, v) in map1) {
                if (map3[v] == null) {
                    map3[v] = 0
                }
                map3[v] = map3[v]!! + 1
            }

            for ((_, v) in map2) {
                if (map4[v] == null) {
                    map4[v] = 0
                }
                map4[v] = map4[v]!! + 1
            }
            for ((k, v) in map3) {
                if (map4[k] != v)
                    return false
            }
            return true
        }
    }
}