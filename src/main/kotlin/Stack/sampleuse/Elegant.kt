package Stack.sampleuse

import Stack.StackImpl

fun main() {

    val stack = StackImpl<Int>().apply {
        push(1)
        push(2)
        push(3)
    }
    println(stack)
    val poppedElement = stack.pop()
    if (poppedElement != null)
        println("Popped Element $poppedElement")
    println(stack)

}