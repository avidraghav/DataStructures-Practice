fun main() {

}

fun oddEvenList(head: ListNode?): ListNode? {
    var end = head
    var size = 1
    while (end?.next != null) {
        end = end.next
        size++
    }
    if (size == 2) {
        return head
    }
    var ptr = head
    var temp: ListNode?

    repeat(size / 2) {
        temp = ptr?.next
        ptr?.next = temp?.next

        end?.next = temp
        end = end?.next
        end?.next = null

        ptr = ptr?.next
    }

    return head
}





