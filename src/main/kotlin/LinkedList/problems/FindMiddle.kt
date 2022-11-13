package LinkedList.problems

import LinkedList.LinkedList


// Find the middle node of LinkedList given it's head
// problem link https://leetcode.com/problems/middle-of-the-linked-list/
fun main() {

    val linkedList = LinkedList<Int>()
    linkedList.push(1).push(2).push(3).push(4).push(5)
    println("Initial list")
    println(linkedList)

    var currentNode = linkedList.head
    var size = 0
    while (currentNode != null) {
        currentNode = currentNode.next
        size++
    }
    val middlePos: Int = size / 2
    currentNode = linkedList.head
    for(i in 0 until middlePos){
        currentNode = currentNode!!.next
    }

    println("Final list")
    print(currentNode)
}