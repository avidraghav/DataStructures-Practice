package blind75

import LinkedList.LinkedList
import LinkedList.Node

fun main() {
    val list1 = LinkedList<Int>()
    val list2 = LinkedList<Int>()
    list1.push(4).push(2).push(1)
    list2.push(4).push(3).push(1)
    println(list1.head)
    println(list2.head)

    println(mergeTwoLists(list1.head, list2.head))
}

fun mergeTwoLists(list1: Node<Int>?, list2: Node<Int>?): Node<Int>? {

    if (list1 == null && list2 == null) return null

    val nH = Node(0)
    var connector = nH
    var isNhInitialised = false

    var p1: Node<Int>? = list1
    var p2: Node<Int>? = list1?.next

    var p3: Node<Int>? = list2
    var p4: Node<Int>? = list2?.next

    if (p1 != null && p3 != null) {
        isNhInitialised = true
        if (p1.value <= p3.value) {
            nH.value = p1.value
            nH.next = null
            p1 = p2
            p2 = p2?.next
        } else {
            nH.value = p3.value
            nH.next = null
            p3 = p4
            p4 = p4?.next
        }
    }

    while (p1 != null || p3 != null) {
        val node = Node(0)
        if (p1 != null && p3 != null) {
            if (p1.value <= p3.value) {
                node.value = p1.value
                p1 = p2
                p2 = p2?.next
            } else {
                node.value = p3.value
                p3 = p4
                p4 = p4?.next
            }
        } else if (p1 == null && p3 != null) {
            node.value = p3.value
            p3 = p4
            p4 = p4?.next
        } else {
            node.value = p1!!.value
            p1 = p2
            p2 = p2?.next
        }
        node.next = null
        connector.next = node
        connector = node
    }
    return if(isNhInitialised) nH else nH.next
}