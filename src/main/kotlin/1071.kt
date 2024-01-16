fun main() {
    val str1 = "ABCABC"
    val str2 = "ABC"
    val biggestCommonSubstring = longestContinuousSubstring(str1, str2)
    println(biggestCommonSubstring)

}

fun longestContinuousSubstring(str1: String, str2: String): String {
    // find the biggest common substrings
    val substring = StringBuilder()
    var i = 0
    if (str1.length > str2.length) {
        while (i != str2.length) {
            if (str1[i] == str2[i]) {
                substring.append(str1[i])
            }
            i++
        }
    } else {
        while (i != str1.length) {
            if (str1[i] == str2[i]) {
                substring.append(str1[i])
            }
            i++
        }
    }
    return substring.toString()
}