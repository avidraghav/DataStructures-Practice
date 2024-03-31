fun main() {
    val s = "luffy is still joyboy"
    println(lengthOfLastWord(s))
}

fun lengthOfLastWord(s: String): Int {
    var i = s.lastIndex
    var endIndex = 0
    var startIndex = 0
    while (i >= 0) {
        while (s[i] == ' ') {
            i--
        }
        endIndex = i
        while (s[i] != ' ') {
            i--
            if (i == -1)
                break
        }
        startIndex = i
        break
    }
    return  endIndex - startIndex
}