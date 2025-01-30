package graph

import java.util.*

fun main() {
    val graph = mapOf(
        1 to listOf(2, 3),
        2 to listOf(1, 4),
        3 to listOf(1, 5),
        4 to listOf(2, 5),
        5 to listOf(3, 4)
    )
    val source = 1
    val target = 5

    graph.printBfs2(source)

}

fun Map<Int, List<Int>>.printBfs2(start: Int) {
    val visited = MutableList(this.size+1) { false }
    val q = ArrayDeque<Int>()
    q.add(start)
    visited[q.first]=true

    while(q.isEmpty().not()){
        print(q.first)
        this[q.first]?.forEach { neighbour->
            if(!visited[neighbour]){
                q.add(neighbour)
                visited[neighbour]=true
            }
        }
        q.remove()
    }
}






















