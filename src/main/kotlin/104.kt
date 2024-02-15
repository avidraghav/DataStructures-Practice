fun main() {

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
// Time and Space O(N)
fun maxDepth(root: TreeNode?): Int {
    val q = java.util.ArrayDeque<TreeNode>()
    var nodesAtCurrentLevel = 0
    var height = 0

    if (root != null) {
        q.add(root)
    }

    while (q.size != 0) {
        nodesAtCurrentLevel = q.size
        height++
        while (nodesAtCurrentLevel > 0) {
            val node = q.remove()
            node.left?.let { q.add(it) }
            node.right?.let { q.add(it) }
            nodesAtCurrentLevel--
        }
    }
    return height
}