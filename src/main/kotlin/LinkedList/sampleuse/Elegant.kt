package LinkedList

fun main(args: Array<String>) {

    val linkedList = LinkedList<Int>()
    linkedList
        .push(1)
        .push(2)
        .push(3)
        .append(4)
        .append(5)
        .append(6)
        .insert(0, 2)
        .insert(7, 3)
        .popAt(1)
        .popAt(2)
        .popAt(4)
        .popAt(5)


    print(linkedList)
}