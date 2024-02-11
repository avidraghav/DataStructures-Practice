package Tree

import Queue.QueueImpl

typealias Visitor<T> = (TreeNode<T>) -> Unit

class TreeNode<T>(
    val value: T,
    private val children: MutableList<TreeNode<T>> = mutableListOf(),
) {
    fun add(child: TreeNode<T>) = children.add(child)

    fun forEachDepthFirst(visit: Visitor<T>) {
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }

    fun forEachPrintEachLevel() {
        val q = QueueImpl<TreeNode<T>>()
        var nodesAtCurrentLevel = 0

        q.add(this)

        while (q.size != 0) {
            nodesAtCurrentLevel = q.size

            while (nodesAtCurrentLevel > 0) {
                val node = q.remove()
                node?.let {
                    print("${node.value} ")
                    node.children.forEach { q.add(it) }
                    nodesAtCurrentLevel--
                } ?: break
            }
            println()
        }

    }

    fun forEachLevelOrder(visit: Visitor<T>) {
        visit(this)
        val queue = QueueImpl<TreeNode<T>>()
        children.forEach { queue.remove() }
        var node = queue.remove()
        while (node != null) {
            visit(node)
            node.children.forEach { queue.remove() }
            node = queue.remove()
        }
    }
}

fun main() {
    val hot = TreeNode("Hot")
    val cold = TreeNode("Cold")

    val beverages = TreeNode("Beverages")
    val tea = TreeNode("Tea")
    val greenTea = TreeNode("Green-Tea")
    val coffee = TreeNode("Coffee")
    val soda = TreeNode("Soda")
    val lemonade = TreeNode("Lemonade")
    val pepsi = TreeNode("Pepsi")

    beverages.run {
        add(hot)
        add(cold)
    }
    hot.run {
        add(tea)
        add(coffee)
    }
    tea.add(greenTea)
    cold.run {
        add(soda)
        add(lemonade)
        add(pepsi)
    }
    pepsi.add(TreeNode("Diet"))

//    beverages.forEachDepthFirst {
//        println(it.value)
//    }
    beverages.forEachPrintEachLevel()
}



