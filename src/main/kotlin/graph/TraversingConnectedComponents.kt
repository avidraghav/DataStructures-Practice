package graph

import java.util.ArrayDeque

fun main() {
//    val graph = mapOf(
//        1 to listOf(2),
//        2 to listOf(1, 3),
//        3 to listOf(2),
//        4 to listOf(5),
//        5 to listOf(4, 6),
//        6 to listOf(5),
//        7 to listOf(8),
//        8 to listOf(7)
//    )

    val graph = mapOf(
        1 to listOf(2, 3),
        2 to listOf(1, 3),
        3 to listOf(1, 2),
        4 to listOf(5),
        5 to listOf(4),
        6 to listOf(7, 8),
        7 to listOf(6),
        8 to listOf(6)
    )

    val start = 1
    val visited = MutableList(graph.size + 1) { false }
//    val q = ArrayDeque<Int>()

//    println("Printing BFS")
//    visited.forEachIndexed { node, isVisited ->
//        if (node == 0)
//            return@forEachIndexed
//
//        if (!isVisited) {
//            q.add(node)
//            graph.printDisconnectedGraphBfs(node, q, visited)
//        }
//    }
    println("Printing DFS")
    visited.forEachIndexed { node, isVisited ->

        if (node == 0)
            return@forEachIndexed

        if (!visited[node])
            graph.printDisconnectedGraphDfs(node, visited)
    }

}

fun Map<Int, List<Int>>.printDisconnectedGraphBfs(node: Int, q: ArrayDeque<Int>, visited: MutableList<Boolean>) {
    while (q.isNotEmpty()) {
        println(q.first)
        this[node]?.forEach { neighbour ->
            if (!visited[neighbour]) {
                q.add(neighbour)
                visited[neighbour] = true
            }
        }
        q.remove()
    }
}

fun Map<Int, List<Int>>.printDisconnectedGraphDfs(node: Int, visited: MutableList<Boolean>) {
    println(node)
    visited[node] = true
    this[node]?.forEach { neighbour ->
        if (!visited[neighbour]) {
            visited[neighbour] = true
            printDisconnectedGraphDfs(neighbour, visited)
        }
    }
}










