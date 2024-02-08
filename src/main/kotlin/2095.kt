fun main() {
    // delete middle node
    val n1 = ListNode(1)
    val n2 = ListNode(2)
    val n3 = ListNode(3)
    n1.next = n2
    n2.next = n3
    n3.next = null

    deleteMiddle(n1)
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

// use fast and slow pointer to get to the middle with only a
// single traversal
// Time: O(n) Space O(1)
fun deleteMiddle(head: ListNode?): ListNode? {
    if (head?.next == null)
        return null
    var slow = head
    var fast = head
    var pre: ListNode? = null

    while (fast != null && fast.next != null) {
        pre = slow
        slow = slow?.next
        fast = fast.next?.next
    }

    pre?.next = pre?.next?.next

    return head
}

// Naive: Time: O(n) Space O(1) 2 traversals
//fun deleteMiddle(head: ListNode?): ListNode? {
//    if (head?.next == null)
//        return null
//    var ptr1 = head
//    var size = 0
//
//    // O(n)
//    while (ptr1 != null) {
//        ptr1 = ptr1.next
//        size++
//    }
//
//    ptr1 = head
//    val middle = if (size % 2 == 0)
//        size / 2 + 1
//    else {
//        ((size.toFloat() / 2) + 0.5).toInt()
//    }
//    // O(n/2 - 2)
//    repeat(middle - 2) {
//        ptr1 = ptr1?.next
//    }
//    val ptr2: ListNode? = ptr1?.next
//
//    ptr1?.next = ptr2?.next
//    ptr2?.next = null
//
//    return head
//}