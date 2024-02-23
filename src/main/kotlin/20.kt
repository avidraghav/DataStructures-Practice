fun main() {
    val s = "(])"
    println(isValid(s))
}

fun isValid(s: String): Boolean {

    val stack = java.util.ArrayDeque<Char>()

    if (s.length == 1)
        return false
    if (s[0] == ')' || s[0] == ']' || s[0] == '}')
        return false

    for (c in s) {
        if (c != ')' && c != ']' && c != '}') {
            stack.push(c)
        } else {
            when (c) {
                ')' -> {
                    if (stack.peek() == '(')
                        stack.pop()
                    else stack.push(c)
                }

                ']' -> {
                    if (stack.peek() == '[')
                        stack.pop()
                    else stack.push(c)
                }

                '}' -> {
                    if (stack.peek() == '{')
                        stack.pop()
                    else stack.push(c)
                }
            }
        }
    }
    return stack.isEmpty()
}