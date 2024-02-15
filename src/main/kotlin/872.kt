fun main() {
//    val t1 = mutableListOf(3, 5, 6, null, null, 2, 7, null, null, 4, null, null, 1, 9, null, null, 8, null, null)
//    val t2 = mutableListOf(3, 5, 6, null, null, 7, null, null, 1, 4, null, null, 2, 9, null, null, 8, null, null)

    val t1 = mutableListOf(1, 2, null, null, 3, null, null)
    val t2 = mutableListOf(1, 3, null, null, 2, null, null)

    val root1 = createTree(t1)
    val root2 = createTree(t2)
    println(leafSimilar(root1, root2))
}

typealias TreeNodeVisitor = (TreeNode) -> Unit

fun TreeNode.traversePreOrderWithNull(visit: TreeNodeVisitor) {
    visit(this)
    this.left?.traversePreOrderWithNull(visit) ?: visit(this)
    this.right?.traversePreOrderWithNull(visit) ?: visit(this)
}

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    val leavesOneBuilder = StringBuilder()
    val leavesTwoBuilder = StringBuilder()

    root1?.traversePreOrderWithNull { node ->
        if (node.left == null && node.right == null) {
            leavesOneBuilder.append(node.`val`)
        }
    }
    root2?.traversePreOrderWithNull { node ->
        if (node.left == null && node.right == null) {
            leavesTwoBuilder.append(node.`val`)
        }
    }
    return if (leavesOneBuilder.toString() == leavesTwoBuilder.toString()) {
        return true
    } else {
        false
    }

}

fun createTree(list: MutableList<Int?>): TreeNode? {
    val rootValue = list.removeFirst() ?: return null

    val root = TreeNode(rootValue)
    root.left = createTree(list)
    root.right = createTree(list)
    return root
}

//fun leafSimilar(root1: BinaryNode<Int>?, root2: BinaryNode<Int>?): Boolean {
//    val leavesOneBuilder = StringBuilder()
//    val leavesTwoBuilder = StringBuilder()
//
//    root1?.traversePreOrderWithNull2 { node ->
//        if (node.leftChild == null && node.rightChild == null) {
//            leavesOneBuilder.append(node.value)
//        }
//    }
//    root2?.traversePreOrderWithNull2 { node ->
//        if (node.leftChild == null && node.rightChild == null) {
//            leavesTwoBuilder.append(node.value)
//        }
//    }
//    return if (leavesOneBuilder.toString() == leavesTwoBuilder.toString()) {
//        return true
//    } else {
//        false
//    }
//
//}

//fun <T : Any> createTree(list: MutableList<T?>): BinaryNode<T>? {
//    val rootValue = list.removeFirst() ?: return null
//
//    val root = BinaryNode(rootValue)
//    root.leftChild = createTree(list)
//    root.rightChild = createTree(list)
//    return root
//}