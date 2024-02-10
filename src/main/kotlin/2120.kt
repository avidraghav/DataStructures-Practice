import LinkedList.LinkedList
import LinkedList.Node

fun main() {
    val list = LinkedList<Int>()
    list.push(4).push(2).push(2).push(3)
    println(list.head)
    println(pairSum(list.head))
}

fun pairSum(head: Node<Int>?): Int {
    // naive way is to reverse one of the list and
    // then sum the corresponding elements (to reverse see 206.kt)
    var p1 = head
    var p2 = reverseList(head?.copy())
    var size = 1
    var max = 0

    while (p1 != null) {
        p1 = p1.next
        size++
    }
    println("size $size")

    p1 = head
    repeat(size / 2) {
        val sum = p1?.value!! + p2?.value!!
        if (sum > max) {
            max = sum
        }
        p1 = p1?.next
        p2 = p2?.next
    }

    return max

}