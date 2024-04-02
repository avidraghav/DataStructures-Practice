fun main() {
    val p = TreeNode(1)
    println(isSameTree(p, null))
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
// traverse each of the tree, if they are structurally equal
// then there traversals should be same
    var areTreesSame = true
    val pTraversal = mutableListOf<Int?>()
    val qTraversal = mutableListOf<Int?>()
    if (p == null) pTraversal.add(null)
    p?.traversePreOrderWithNull2 {
        println("p ${it}")
        pTraversal.add(it)
    }
    if (q == null) qTraversal.add(null)
    q?.traversePreOrderWithNull2 {
        println("q ${it}")
        qTraversal.add(it)
    }
    run breaking@{
        pTraversal.forEachIndexed { index, value ->
            if (value != qTraversal[index]) {
                areTreesSame = false
                return@breaking
            }
        }
    }

    return areTreesSame

}


fun TreeNode.traversePreOrderWithNull2(visit: (Int?) -> Unit) {
    visit(this.`val`)
    this.left?.traversePreOrderWithNull2(visit) ?: visit(null)
    this.right?.traversePreOrderWithNull2(visit) ?: visit(null)
}
