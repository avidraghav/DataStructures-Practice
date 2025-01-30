package graph

fun main(){
    val graph = listOf(listOf(1,2),listOf(0,2,3),listOf(0,1),listOf(1))
    graph.printGraph()
}

fun List<List<Int>>.printGraph() {
    // this should print each edge

    this.forEachIndexed { index, edges ->
        edges.forEach { edge ->
            print("$index -> $edge ")
        }
        println()
    }
}

/*
* 0 - 1,2
* 1 - 0
* 2- 3,4
* 3 - 2
* 4 - 2
* */