package LinkedList.problems

import LinkedList.LinkedList
import LinkedList.Node


// problem-link https://leetcode.com/problems/add-two-numbers/

// testcase-1
//val l1 = LinkedList<Int>().append(2).append(4).append(3)
//val l2 = LinkedList<Int>().append(5).append(6).append(4)

// testcase-2
val l1 = LinkedList<Int>().append(9).append(9).append(9).append(9).append(9).append(9).append(9)
val l2 = LinkedList<Int>().append(9).append(9).append(9).append(9)

// testcase-3
//val l1 = LinkedList<Int>().append(0)
//val l2 = LinkedList<Int>().append(0)

val gH1 = l1.head
val gH2 = l2.head

var head: Node<Int>? = null
var tail: Node<Int>? = null
var p1 = gH1
var p2 = gH2
var size = 0
var carry = 0
var stop1 = false
var stop2 = false


fun main() {

    while (p1 != null || p2 != null) {
        val v1: Int
        val v2: Int
        if (p1 != null) {
            v1 = p1!!.value
        } else {
            v1 = 0
            stop1 = true
        }
        if (p2 != null) {
            v2 = p2!!.value
        } else {
            v2 = 0
            stop2 = true
        }
        var v = v1 + v2

        if (carry != 0) {
            v = v + carry
            carry = 0
        }

        if (v > 9) {
            append(v % 10)
            carry = v / 10
        } else
            append(v)


        if(!stop1 && !stop2){
            p1 = p1!!.next
            p2 = p2!!.next
        }

        if(stop1 && !stop2)
            p2 = p2!!.next
        if(stop2 && !stop1)
        p1 = p1!!.next
    }
    if (carry != 0)
        append(carry)

    println(head)
}

private fun append(value: Int) {
    val node = Node<Int>(value)
    if (size == 0) {
        head = node
        tail = head
    } else if (size == 1) {
        head!!.next = node
        tail = node
    } else {
        tail!!.next = node
        tail = node
    }
    size++
}


















