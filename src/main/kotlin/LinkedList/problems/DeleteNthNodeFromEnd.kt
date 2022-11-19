package LinkedList.problems

import LinkedList.LinkedList


// problem-link https://leetcode.com/problems/remove-nth-node-from-end-of-list/
fun main(){

    val n = 2
    val linkedList = LinkedList<Int>()
    linkedList.append(1).append(2).append(3).append(4).append(5)
    println("Initial list")
    println(linkedList)

    var size = 0
    var p1 = linkedList.head
    var p2 = linkedList.head

    while(p1!=null){
        p1 = p1.next
        size++
    }
    p1 = linkedList.head
    if(size == 1 ){
        p1 = null
        println(p1)
        return
    }

    val n1 = size - n

    if(n1==0){
        // delete 1st node
        p1= p1!!.next
        println(p1)
        return
    }

    for(i in 1 until n1){
        p1 = p1!!.next
    }

    p2 = p1!!.next

    p1.next = p2!!.next
    p2.next = null

    println("Final list")
    println(linkedList)

}