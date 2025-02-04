package graph

import java.util.ArrayDeque

fun main() {
    val grid = listOf(
        listOf(0, 1, 1, 0),
        listOf(0, 1, 1, 0),
        listOf(0, 0, 1, 0),
        listOf(0, 0, 0, 0),
        listOf(1, 1, 0, 1)
    )

    println(getIslands(grid))
}


fun getIslands(grid: List<List<Int>>): Int {
    var islands = 0
    var rowC = 0
    var columnC = 0
    var currentC = Pair(0, 0)
    val visited = MutableList<MutableList<Boolean>>(grid.size) { MutableList<Boolean>(grid.first().size) { false } }

    grid.forEach { row ->
        row.forEach { node ->
            currentC = Pair(rowC, columnC)
            if (node == 1 && !visited[rowC][columnC]) {
                visited[rowC][columnC] = true
                traverseBfs(currentC, grid, visited)
                islands++
            }
            columnC++
        }
        columnC = 0
        rowC++
    }

    return islands
}

fun traverseBfs(start: Pair<Int, Int>, grid: List<List<Int>>, visited: MutableList<MutableList<Boolean>>) {

    var rowC = start.first
    var columnC = start.second
    val q = ArrayDeque<Pair<Int, Int>>()
    q.add(start)
    visited[rowC][columnC] = true

    while (q.isNotEmpty()) {
        println("Coordinates: ${q.first.first}, ${q.first.second}")
        for (i in (rowC - 1)..(rowC + 1)) {
            for (j in (columnC - 1)..(columnC + 1)) {
                if (i in grid.indices && j in grid[0].indices && !visited[i][j] && grid[i][j] != 0) {
                    visited[i][j] = true
                    q.add(Pair(i, j))
                }
            }
        }
        q.remove()
        if (q.size == 0)
            break

        rowC = q.first.first
        columnC = q.first.second
    }

}
