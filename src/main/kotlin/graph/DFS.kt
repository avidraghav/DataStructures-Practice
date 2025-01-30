package graph

fun main() {
//    val graph = mapOf(
//        1 to listOf(2, 3),
//        2 to listOf(1, 4),
//        3 to listOf(1, 5),
//        4 to listOf(2, 5),
//        5 to listOf(3, 4)
//    )
//    val source = 1

    val graph = mapOf(
        1 to listOf(2, 3),
        2 to listOf(1, 5, 6),
        3 to listOf(1, 7, 4),
        4 to listOf(3, 8),
        5 to listOf(2),
        6 to listOf(2),
        7 to listOf(3, 8),
        8 to listOf(4, 7)
    )
    val source = 1

    graph.printDfs(source)
}

fun Map<Int, List<Int>>.printDfs(start: Int) {
    val visited = MutableList(this.size + 1) { false }
    visited[start] = true
    dfs(start, this, visited)
}


fun dfs(node: Int, graph: Map<Int, List<Int>>, visited: MutableList<Boolean>) {
    print(node)
    visited[node] = true

    graph[node]?.forEach { neighbour ->
        if (visited[neighbour] != true) {
            dfs(neighbour, graph, visited)
        }
    }
}











