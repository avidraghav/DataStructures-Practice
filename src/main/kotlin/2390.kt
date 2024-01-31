import Stack.StackImpl

fun main() {
    val s = "leet**cod*e"
    //val s = "erase*****"
    println(removeStars(s))
}

// Time- O(n) Space- O(n-2*(number of stars))
fun removeStars(s: String): String {
    val stack = StackImpl<Char>()
    for (c in s) {
        if (c != '*') {
            stack.push(c)
        } else {
            stack.pop()
        }
    }
    val resultBuilder = StringBuilder()

    resultBuilder.append(stack)

    return resultBuilder.toString().reversed()
}