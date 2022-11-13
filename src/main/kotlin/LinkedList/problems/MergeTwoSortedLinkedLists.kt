package LinkedList.problems

import LinkedList.LinkedList
import LinkedList.Node


// Merge the given Sorted LinkedLists in a sorted way given their heads
// problem link https://leetcode.com/problems/merge-two-sorted-lists/
fun main() {
    val l1 = LinkedList<Int>()
    l1.append(1).append(2).append(4)
    val l2 = LinkedList<Int>()
    l2.append(1).append(3).append(4)

    println("list 1")
    println(l1)

    println("list 2")
    println(l2)

    val list1 = l1.head
    val list2 = l2.head

    if (list1 == null && list2 == null) {
        println(list1)
        return
    }
    
    var head: Node<Int>? = null
    var p1: Node<Int>? = null
    var p2: Node<Int>? = null

    if (list1!!.value < list2!!.value) {
        p1 = list1
        p2 = list2
        head = list1
    } else {
        p1 = list2
        p2 = list1
        head = list2
    }

    var temp: Node<Int>? = p1
    while (p1 != null && p2 != null) {
        if (p1.value <= p2.value) {
            temp = p1
            p1 = p1.next
            if (p1 == null) {
                temp.next = p2
            }
        } else {
            temp!!.next = p2
            // swap p1 and p2
            val t: Node<Int> = p1
            p1 = p2
            p2 = t
            temp = p1
        }
    }

    println("final list")
    println(head)
}




