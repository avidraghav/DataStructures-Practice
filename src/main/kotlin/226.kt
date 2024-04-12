fun main() {
    val node = TreeNode(1)
    val node2 = TreeNode(2)
    val node3 = TreeNode(3)
    val node4 = TreeNode(4)
    val node5 = TreeNode(5)
    val node6 = TreeNode(6)
    val node7 = TreeNode(7)

    node.apply {
        left = node2
        node.right = node3
    }
    node2.apply {
        left = node4
        right = node5
    }
    node3.apply {
        left = node6
        right = node7
    }
    invertTree(node)?.traverseInOrder()
}


fun invertTree(root: TreeNode?): TreeNode? {

    if (root == null)
        return null

    val temp = root.left
    root.left = root.right
    root.right = temp
    
    invertTree(root.left)
    invertTree(root.right)


    return root
}


fun TreeNode.traverseInOrder() {
    this.left?.traverseInOrder()
    print(this.`val`)
    this.right?.traverseInOrder()
}