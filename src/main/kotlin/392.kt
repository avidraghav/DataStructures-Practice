fun main() {
//    val s = "abc"
//    val t = "ahbgdc"
//    val s = "axc"
//    val t = "ahbgdc"
    val s = ""
    val t = "ahbgdc"
    println(isSubsequence(s, t))
}

fun isSubsequence(s: String, t: String): Boolean {
    if (s.length > t.length)
        return false
    if (s.isEmpty()) return true

    var i = 0

    for (c1 in t) {
        if (c1 == s[i]) {
            i++
            if (i == s.length)
                break
        }
    }
    return i == s.length
}