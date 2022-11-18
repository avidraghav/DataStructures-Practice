package LinkedList.problems

import LinkedList.LinkedList


// problem link- https://leetcode.com/problems/rotate-list/
// Rotate LinkedList Anticlockwise
fun main() {

    val linkedList = LinkedList<Int>().append(1).append(2).append(3).append(4).append(5)

    val gH = linkedList.head
    val gK = 2


    var p1 = gH
    var k = gK
    var size = 0


    while (p1 != null) {
        size++
        p1 = p1.next
    }
    p1 = gH
    var p2 = gH
    var h = gH

    println(size)

    if (k > size) {
        while (k > size) {
            k -= size
        }
    }

    for (i in 1..k) {
        while (p1!!.next != null) {
            p2 = p1
            p1 = p1.next
        }

        p1.next = h
        p2!!.next = null
        h = p1
        p1 = h
        p2 = h
    }

    print(p1)

}











