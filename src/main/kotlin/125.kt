fun main() {
    val s = "A man, a plan, a canal: Panama"
    println(isPalindrome(s))
}


fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.length - 1

    if (end == 1) {
        return if (s[start].code in 65..90 || s[start].code in 97..122 || s[start].code in 48..57) {
            if (s[end].code in 65..90 || s[end].code in 97..122 || s[end].code in 48..57) {
                s[start].lowercaseChar() == s[end].lowercaseChar()
            } else {
                true
            }
        } else {
            true
        }
    }

    var result = true

    while (start < end) {
        if (s[start].code in 65..90 || s[start].code in 97..122 || s[start].code in 48..57) {
            if (s[end].code in 65..90 || s[end].code in 97..122 || s[end].code in 48..57) {
                if (s[start].lowercaseChar() != s[end].lowercaseChar()) {
                    result = false
                    break
                } else {
                    start++
                    end--
                }
            } else {
                end--
                // result = false
            }
        } else {
            start++
            //result = false
        }
    }
    return result
}