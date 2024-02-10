import LinkedList.LinkedList
import LinkedList.Node

fun main() {
    val list = LinkedList<Int>()
    list.push(1).push(2).push(3).push(4).push(5)
    println(list.head)
    println(reverseList(list.head))
}

// Time: O(n) Space: O(1)
fun reverseList(head: Node<Int>?): Node<Int>? {

    if (head?.next == null) {
        return head
    }

    var p1 = head
    var p2 = head.next
    var p3 = p2?.next

    // 2 nodes
    if (p3 == null) {
        p2?.next = p1
        p1.next = null
        return p2
    }

    // 3 or more nodes
    while (p3 != null) {
        p2?.next = p1
        if (p1 == head)
            p1.next = null

        p1 = p2
        p2 = p3
        p3 = p3.next
    }
    p2?.next = p1

    return p2
}