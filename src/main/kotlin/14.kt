fun main() {
    // val strs = arrayOf("flower", "flow", "flight")
    val strs = arrayOf("dog", "racecar", "car")
    println(longestCommonPrefix(strs))
}

fun longestCommonPrefix(strs: Array<String>): String {
    var i = 0
    val commonPrefix = StringBuilder()
    val temp = StringBuilder()
    repeat(strs[0].length) {
        strs.forEach { s ->
            if (i < s.length)
                temp.append(s[i])
        }
        i++
        if (temp.toString().length == strs.size && temp.toString().toSet().size == 1) {
            commonPrefix.append(temp.toSet().first())
            temp.clear()
        } else {
            return@repeat
        }
    }

    return commonPrefix.toString()
}