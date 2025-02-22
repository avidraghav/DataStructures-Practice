package graph

import java.util.*


data class DistanceValue(
    val distance: Int,
    val value: Int
)

fun main() {

    val graph = mapOf(
        0 to listOf(
            DistanceValue(4, 1),
            DistanceValue(4, 2)
        ),
        1 to listOf(
            DistanceValue(4, 0),
            DistanceValue(2, 2)
        ),
        2 to listOf(
            DistanceValue(4, 0),
            DistanceValue(2, 1),
            DistanceValue(3, 3),
            DistanceValue(1, 4),
            DistanceValue(6, 5)
        ),
        3 to listOf(
            DistanceValue(3, 2),
            DistanceValue(2, 5)
        ),
        4 to listOf(
            DistanceValue(1, 2),
            DistanceValue(3, 5)
        ),
        5 to listOf(
            DistanceValue(6, 2),
            DistanceValue(2, 3),
            DistanceValue(3, 4)
        ),
    )

    getShortestPathsFromSource(DistanceValue(0, 0), graph).forEach {
        println(it)
    }
}

fun getShortestPathsFromSource(src: DistanceValue, graph: Map<Int, List<DistanceValue>>): List<Int> {

    val distances = MutableList(graph.size) {
        Int.MAX_VALUE
    }

    val minHeap = PriorityQueue<DistanceValue> { a, b ->
        if (a.distance == b.distance) a.value - b.value
        else a.distance - b.distance
    }

    minHeap.add(src)
    distances[src.value] = src.distance


    while (minHeap.isNotEmpty()) {
        val distanceTillSource = minHeap.peek().distance
        graph[minHeap.peek().value]?.forEach { neighbour ->
            val distanceToNeighbour = distanceTillSource + neighbour.distance
            if (distanceToNeighbour < distances[neighbour.value]) {
                distances[neighbour.value] = distanceToNeighbour
                minHeap.add(DistanceValue(distance = distanceToNeighbour, value = neighbour.value))
            }
        }
        minHeap.poll()
    }

    return distances

}












