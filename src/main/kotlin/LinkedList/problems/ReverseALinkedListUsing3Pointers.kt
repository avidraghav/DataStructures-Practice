package LinkedList.problems

import LinkedList.LinkedList
import LinkedList.Node


fun main() {
    val linkedList = LinkedList<Int>()
    linkedList.append(1).append(2).append(3).append(4).append(5)
    println("Initial list")
    println(linkedList)

    if (linkedList.head!!.next == null) {
        println("Final list")
        println(linkedList.head)
        return
    }

    var p1: Node<Int>? = null
    var p2 = linkedList.head
    var p3 = p2!!.next

    while (p3 != null) {
        p2!!.next = p1

        p1 = p2
        p2 = p3
        p3 = p2.next
    }
    p2!!.next = p1
    println("Final list")
    println(p2)
}






















