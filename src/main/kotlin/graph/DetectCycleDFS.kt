package graph

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

    val visited = MutableList(graph.size + 1) { false }
    visited[source] = true
    println( isCyclicDfs(NodeDfs(parent = null, value = source), graph, visited))
}

fun isCyclicDfs(source: NodeDfs, graph: Map<Int, List<Int>>, visited: MutableList<Boolean>): Boolean {
    //print(source)
    graph[source.value]?.forEach { neighbour ->
        if (!visited[neighbour]) {
            visited[neighbour] = true
            isCyclicDfs(NodeDfs(parent = source.value, value = neighbour), graph, visited)
        } else if (neighbour != source.parent) {
            return true
        }
    }

    return false
}

data class NodeDfs(
    val parent: Int?,
    val value: Int,
)