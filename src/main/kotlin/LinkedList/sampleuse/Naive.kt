package LinkedList

fun main(args: Array<String>) {

    val node1 = Node(value = "start")
    val node2 = Node(value = "mid")
    val node3 = Node(value = "end")
    node1.next = node2
    node2.next = node3

    print(node1)
}