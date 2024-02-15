package Tree

import Queue.QueueImpl

typealias BinaryNodeVisitor<T> = (T) -> Unit

class BinaryNode<T>(
    private var value: T,
    private var leftChild: BinaryNode<T>? = null,
    private var rightChild: BinaryNode<T>? = null
) {

    fun addRight(node: BinaryNode<T>) = apply {
        this.rightChild = node
    }

    fun addLeft(node: BinaryNode<T>) = apply {
        this.leftChild = node
    }

    // Time: O(N) Space: O(N)
    fun traverseInOrder(visit: BinaryNodeVisitor<T>) {
        leftChild?.traverseInOrder(visit)
        visit(value)
        rightChild?.traverseInOrder(visit)
    }

    // Time: O(N) Space: O(N)
    fun traversePreOrder(visit: BinaryNodeVisitor<T>) {
        visit(value)
        leftChild?.traversePreOrder(visit)
        rightChild?.traversePreOrder(visit)
    }

    // Time: O(N) Space: O(N)
    fun traversePostOrder(visit: BinaryNodeVisitor<T>) {
        leftChild?.traversePostOrder(visit)
        rightChild?.traversePostOrder(visit)
        visit(value)
    }

    // Time: O(N) Space: O(N)
    fun traverseInLevel(visit: BinaryNodeVisitor<T>) {
        val q = QueueImpl<BinaryNode<T>>()
        var nodesAtCurrentLevel = 0

        q.add(this)

        while (q.size != 0) {
            nodesAtCurrentLevel = q.size

            while (nodesAtCurrentLevel > 0) {
                val node = q.remove()
                node?.let {
                    visit(node.value)
                    node.leftChild?.let { child -> q.add(child) }
                    node.rightChild?.let { child -> q.add(child) }
                    nodesAtCurrentLevel--
                } ?: break
            }
            println()
        }

    }

    fun traversePreOrderWithNull(visit: BinaryNodeVisitor<T?>) {
        visit(value)
        leftChild?.traversePreOrderWithNull(visit) ?: visit(null)
        rightChild?.traversePreOrderWithNull(visit) ?: visit(null)
    }

    fun serialize(): MutableList<T?> {
        val list = mutableListOf<T?>()
        traversePreOrderWithNull {
            list.add(it)
        }
        return list
    }

    fun deserialize(list: MutableList<T?>): BinaryNode<T?>? {
        // 1
        val rootValue = list.removeFirst() ?: return null
        // 2
        val root = BinaryNode<T?>(rootValue)
        root.leftChild = deserialize(list)
        root.rightChild = deserialize(list)
        return root
    }
}


fun main() {
    val tree = BinaryNode(1)
    val two = BinaryNode(2)
    val three = BinaryNode(3)
    val four = BinaryNode(4)
    val five = BinaryNode(5)
    val six = BinaryNode(6)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8)

    tree.addLeft(two)
    tree.addRight(three)
    two.addLeft(four)
    two.addRight(five)

    four.addLeft(seven)
    four.addRight(eight)

    three.addLeft(six)

    val preOrderTraversal = tree.serialize()
    preOrderTraversal.forEach {
        print("$it ")
    }
    println("-------------------")
    val deserializedTree = tree.deserialize(preOrderTraversal)
    deserializedTree?.traversePreOrder {
        print("$it ")
    }


//    print("In-Order ")
//    tree.traverseInOrder {
//        print("$it  ")
//    }
//    println()
//    print("Pre-Order ")
//    tree.traversePreOrder {
//        print("$it  ")
//    }
//    println()
//
//    print("Post-Order ")
//    tree.traversePostOrder {
//        print("$it  ")
//    }
//    println()
//
//    println("In-Level ")
//    tree.traverseInLevel {
//        print("$it  ")
//    }
}