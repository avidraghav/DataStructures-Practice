fun main() {

    println(mergeAlternately("abc", "pqr"))
//    var a = "ab"
//    println(a[2])

}

fun mergeAlternately(word1: String, word2: String): String {
    var i = 0
    var word3 = StringBuilder()

    while (i < word1.length || i < word2.length) {
        word3 = word3.append(
            try {
                word1[i].toString()
            } catch (e: Exception) {
                ""
            }
        ).append(
            try {
                word2[i].toString()
            } catch (e: Exception) {
                ""
            }
        )
        i++
    }
    return word3.toString()
}