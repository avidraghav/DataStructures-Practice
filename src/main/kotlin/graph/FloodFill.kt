package graph

typealias NodeC = Pair<Int, Int>

fun main() {
    val grid = listOf(
        listOf(1, 1, 1),
        listOf(1, 1, 0),
        listOf(1, 0, 1)
    )
    val newColor = 2
    val start = NodeC(1, 1)
    val sourceColor = 1

//    val grid = listOf(
//        listOf(1, 1, 1),
//        listOf(2, 2, 0),
//        listOf(2, 2, 2)
//    )
//    val newColor = 3
//    val start = NodeC(2, 0)
//    val sourceColor = 2

    var j = 0
    var i = 0
    val outputGrid = MutableList(grid.size) { MutableList(grid[0].size) { 0 } }

    grid.forEach { rows ->
        rows.forEach { value ->
            outputGrid[i][j] = value
            j++
        }
        j = 0
        i++
    }

    floodFill(start, outputGrid, newColor, sourceColor)

    println("Final Grid")
    outputGrid.forEach { rows ->
        rows.forEach { value ->
            print(value)
        }
        println()
    }
}


fun floodFill(start: NodeC, grid: MutableList<MutableList<Int>>, newColor: Int, sourceColor: Int) {
    grid[start.first][start.second] = newColor

    val upperNeighbour = getValidUpperNeighbour(start.first, start.second, grid, sourceColor)
    val downNeighbour = getValidDownWardNeighbour(start.first, start.second, grid, sourceColor)
    val leftNeighbour = getValidLeftNeighbour(start.first, start.second, grid, sourceColor)
    val rightNeighbour = getValidRightNeighbour(start.first, start.second, grid, sourceColor)

    leftNeighbour?.let { n->
        floodFill(n,grid,newColor,sourceColor)
    }
    rightNeighbour?.let { n->
        floodFill(n,grid,newColor,sourceColor)
    }
    upperNeighbour?.let { n->
        floodFill(n,grid,newColor,sourceColor)
    }
    downNeighbour?.let { n->
        floodFill(n,grid,newColor,sourceColor)
    }
}

fun getValidUpperNeighbour(r: Int, c: Int, grid: MutableList<MutableList<Int>>, sourceColor: Int): NodeC? {
    return if ((r - 1) in grid.indices && grid[r - 1][c] == sourceColor)
        return NodeC(r - 1, c)
    else null
}

fun getValidDownWardNeighbour(r: Int, c: Int, grid: MutableList<MutableList<Int>>, sourceColor: Int): NodeC? {
    return if ((r + 1) in grid.indices && grid[r + 1][c] == sourceColor)
        return NodeC(r + 1, c)
    else null
}

fun getValidLeftNeighbour(r: Int, c: Int, grid: MutableList<MutableList<Int>>, sourceColor: Int): NodeC? {
    return if ((c - 1) in grid[0].indices && grid[r][c - 1] == sourceColor)
        return NodeC(r, c - 1)
    else null
}

fun getValidRightNeighbour(r: Int, c: Int, grid: MutableList<MutableList<Int>>, sourceColor: Int): NodeC? {
    return if ((c + 1) in grid[0].indices && grid[r][c + 1] == sourceColor)
        return NodeC(r, c + 1)
    else null
}
