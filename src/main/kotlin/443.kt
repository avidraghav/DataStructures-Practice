fun main() {
    val chars = charArrayOf('a','a','a','b','b','a','a')
  //  val chars = charArrayOf('a')
  //  val chars = charArrayOf('a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b')
    val list = compress(chars)
    println(list)
    // println(list.size)
}

//fun compress(chars: CharArray): List<String> {
//    return createOutput(getFrequencyOfDistinctChar(chars))
//}
//
//fun createOutput(map: Map<Char, Int>): List<String> {
//    val output = mutableListOf<String>()
//    for ((k, v) in map) {
//        output.add(k.toString())
//        if (v in 2..9) {
//            output.add(v.toString())
//        } else if (v >= 10) {
//            val new = v.toString()
//            for (n in new) {
//                output.add(n.toString())
//            }
//        } else {
//            continue
//        }
//    }
//    return output
//}
//
//a a b b c c c
//0 1 2 3 4 5 6
fun compress(chars: CharArray): Int {
    var i = 0
    var res = 0
    while (i < chars.size) {
        val target = chars[i]
        var j = i + 1
        var count = 1

        while (j < chars.size && target == chars[j]) {
            count++
            j++
        }
        if (count in 2..9) {
            chars[i + 1] = count.digitToChar()
            res++
        } else if (count >= 10) {
            val new = count.toString()
            new.forEachIndexed { index, c ->
                chars[i + 1 + index] = c
                res++
            }
        }
        i += count
        res++
    }
    println(chars)
    return res
}

//fun compress(chars: CharArray): Int {
//    var i = 0
//    var res = 0
//    while (i < chars.size) {
//        var groupLength = 1
//        while (i + groupLength < chars.size && chars[i + groupLength] == chars[i]) {
//            groupLength++
//        }
//        chars[res++] = chars[i]
//        if (groupLength > 1) {
//            for (c in groupLength.toString().toCharArray()) {
//                chars[res++] = c
//            }
//        }
//        i += groupLength
//    }
//    println(chars)
//    return res
//}