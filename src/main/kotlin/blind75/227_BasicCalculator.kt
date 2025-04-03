package blind75

import java.util.Stack

fun main() {
    val s = "1-1+1"
    println(calculate(s))
}

fun calculate(s: String): Int {
    val stack = Stack<Int>()
    var num = 0
    var sign = '+'

    for (i in s.indices) {
        val c = s[i]

        if (c.isDigit()) {
            num = num * 10 + (c - '0')
        }

        if (!c.isDigit() && c != ' ' || i == s.lastIndex) {
            when (sign) {
                '+' -> stack.push(num)
                '-' -> stack.push(-num)
                '*' -> stack.push(stack.pop() * num)
                '/' -> stack.push(stack.pop() / num)
            }
            sign = c
            num = 0
        }
    }

    return stack.sum()
}
