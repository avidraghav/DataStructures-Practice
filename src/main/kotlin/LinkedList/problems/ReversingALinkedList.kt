package LinkedList.problems

import LinkedList.LinkedList
import LinkedList.Node

// Reverse a LinkedList given it's head
// problem link https://leetcode.com/problems/reverse-linked-list/
fun main() {

    val linkedList = LinkedList<Int>()
    linkedList.push(1).push(2).push(3).push(4)
    println("Initial list")
    println(linkedList)

    var currentNode = linkedList.head
    var prev: Node<Int>? = null
    while (currentNode != null) {
        val temp = currentNode.next
        currentNode.next = prev
        prev = currentNode
        currentNode = temp
    }
    println("Final list")
    println(prev)

}
