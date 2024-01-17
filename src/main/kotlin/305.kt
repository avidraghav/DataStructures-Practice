fun main() {
    val s = "leetcode"
    println(reverseVowels(s))
}

fun reverseVowels(s: String): String {
    if(s.length==1)
        return s
    var i = 0
    var j = s.length - 1
    val builder = StringBuilder()
    builder.append(s)
    while (i < j) {
        if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u' ||
            s[i] == 'A' || s[i] == 'E' || s[i] == 'I' || s[i] == 'O' || s[i] == 'U'
        ) {
            if (s[j] == 'a' || s[j] == 'e' || s[j] == 'i' || s[j] == 'o' || s[j] == 'u' ||
                s[j] == 'A' || s[j] == 'E' || s[j] == 'I' || s[j] == 'O' || s[j] == 'U'
            ) {
                val temp = s[i]
                builder[i] = s[j]
                builder[j] = temp
                i++
                j--
            } else {
                j--
            }
        } else {
            i++
        }
    }
    return builder.toString()
}
