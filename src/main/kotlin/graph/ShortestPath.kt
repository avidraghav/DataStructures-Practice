package graph

import java.util.ArrayDeque

fun main() {
//    val graph = mapOf(
//        1 to listOf(2, 3),
//        2 to listOf(1, 4),
//        3 to listOf(1, 5),
//        4 to listOf(2, 5),
//        5 to listOf(3, 4)
//    )
//    val source = 1
//    val target = 5

    val graph = mapOf(
        1 to listOf(2, 3, 4),
        2 to listOf(1, 5, 6),
        3 to listOf(1, 7, 8),
        4 to listOf(1, 9, 10),
        5 to listOf(2, 11, 12),
        6 to listOf(2, 13, 14),
        7 to listOf(3, 15, 16),
        8 to listOf(3, 17, 18),
        9 to listOf(4, 19, 20),
        10 to listOf(4, 21, 22),
        11 to listOf(5),
        12 to listOf(5),
        13 to listOf(6),
        14 to listOf(6),
        15 to listOf(7),
        16 to listOf(7),
        17 to listOf(8),
        18 to listOf(8),
        19 to listOf(9),
        20 to listOf(9),
        21 to listOf(10),
        22 to listOf(10)
    )
    val source = 1
    val target = 18


    graph.printShortestPath(source, target)

}

fun Map<Int, List<Int>>.printShortestPath(start: Int, target: Int) {
    val visited = MutableList(this.size + 1) { false }
    val q = ArrayDeque<Int>()
    val parentMap = mutableMapOf<Int, Int>()
    q.add(start)
    visited[q.first] = true
    val targetFound = false

    while (q.isEmpty().not()) {
        print(q.first)
        this[q.first]?.forEach { neighbour ->
            if (!visited[neighbour]) {
                q.add(neighbour)
                visited[neighbour] = true
                parentMap[neighbour] = q.first
                if (neighbour == target) {
                    return@forEach
                }
            }
        }
        if (targetFound)
            break
        else
            q.remove()
    }

    println()
    val path = mutableListOf<Int>()
    var n = target
    path.add(target)
    while (n != start) {
        path.add(parentMap[n]!!)
        n = parentMap[n]!!
    }
    path.asReversed().forEach {
        print(it)
    }


}