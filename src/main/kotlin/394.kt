import Stack.StackImpl

fun main() {
    // val s = "3[a]2[bc]"
//    val s = "3[a2[c]]"
    val s = "2[abc]3[cd]ef"
    println(decodeString(s))
}

fun decodeString(s: String): String {
    val stack = StackImpl<Char>()
    val tempStorage = StringBuilder()
    val multiplier = StringBuilder()

    for (c in s) {
        if (c != ']') {
            stack.push(c)
        } else {
            while (stack.peek() != '[') {
                tempStorage.append(stack.peek())
                stack.pop()
            }
            stack.pop()
            while (stack.peek() != null && stack.peek()!!.isDigit().not()) {
                tempStorage.append(stack.peek())
            }
            while (stack.peek() != null && stack.peek()!!.isDigit()) {
                multiplier.append(stack.peek())
                stack.pop()
            }
            tempStorage.reverse()
            multiplier.reverse()
            var temp: String? = tempStorage.toString()
            repeat(multiplier.toString().toInt() - 1) {
                tempStorage.append(temp)
            }
            temp = null
            for (tempChar in tempStorage) {
                stack.push(tempChar)
            }
            tempStorage.clear()
            multiplier.clear()
        }
    }
    return stack.toString().reversed()
}










