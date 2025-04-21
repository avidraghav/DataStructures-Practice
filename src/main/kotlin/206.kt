import LinkedList.LinkedList
import LinkedList.Node

fun main() {
    val list = LinkedList<Int>()
    list.push(5).push(4).push(3).push(2).push(1)
    println(list.head)
    println(reverseList(list.head))
}

// Time: O(n) Space: O(1)
fun reverseList(head: Node<Int>?): Node<Int>? {

    var p1 = head
    var p2 = p1?.next
    var p3 = p2?.next

    p1?.next = null
    p2?.next = p1

    p1 = p2
    p2 = p3
    p3 = p3?.next

    while (p2 != null || p3 != null) {
        p2?.next = p1

        p1 = p2
        p2 = p3
        p3 = p3?.next
    }
    return p1
}