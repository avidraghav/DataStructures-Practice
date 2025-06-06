package graph

import java.util.*

fun main() {

//    2 —— 5
//    /      \
//    1        7
//    \      /
//    3 —— 6
//    |
//    4

//    val graph = mapOf(
//        1 to listOf(2, 3),
//        2 to listOf(1, 5),
//        3 to listOf(1, 4, 6),
//        4 to listOf(3),
//        5 to listOf(2, 7),
//        6 to listOf(3, 7),
//        7 to listOf(5, 6)
//    )
//    val source = 1

//    1 — 2 — 3 — 4
//    |
//    5 — 6 — 7

    val graph = mapOf(
        1 to listOf(2, 5),
        2 to listOf(1, 3),
        3 to listOf(2, 4),
        4 to listOf(3),
        5 to listOf(1, 6),
        6 to listOf(5, 7),
        7 to listOf(6)
    )
    val source = 1


    println(isCyclicBfs(source, graph))
}

fun isCyclicBfs(source: Int, graph: Map<Int, List<Int>>): Boolean {

    val visited = MutableList(graph.size + 1) { false }

    // Add node with their parent
    val q = ArrayDeque<NodeBfs>()

    q.add(NodeBfs(null, source))
    visited[source] = true

    while (q.isNotEmpty()) {
        graph[q.first.value]?.forEach { neighbour ->
            if (!visited[neighbour]) {
                visited[neighbour] = true
                q.add(NodeBfs(parent = q.first.value, value = neighbour))
            } else if (q.first.parent != neighbour) {
                return true
            }
        }
        q.remove()
    }

    return false
}

data class NodeBfs(
    val parent: Int?,
    val value: Int,
)