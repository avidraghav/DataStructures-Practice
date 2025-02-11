package graph

// convert all 0's (group of 0's) to 1 which are surrounded by 1 in 4 directions
fun main() {
    val grid = listOf(
        listOf('X', 'X', 'X', 'X'),
        listOf('X', 'O', 'X', 'X'),
        listOf('X', 'O', 'O', 'X'),
        listOf('X', 'O', 'X', 'X'),
        listOf('X', 'X', 'O', 'O'),
    )

    convert(grid).forEach { println(it) }

}

fun convert(grid: List<List<Char>>): List<List<Char>> {
    val output = grid.map { it.toList().toMutableList() }.toMutableList()

    val visited = MutableList(grid.size) {
        MutableList(grid[0].size) {
            false
        }
    }

    // top
    for (c in grid[0].indices) {
        if (grid[0][c] == 'O' && !visited[0][c]) {
            traversDfs(Pair(0, c), grid, visited)
        }
    }

    // right
    for (r in grid.indices) {
        if (grid[r][grid[0].size - 1] == 'O' && !visited[r][grid[0].size - 1]) {
            traversDfs(Pair(r, grid[0].size - 1), grid, visited)
        }
    }

    // bottom
    for (c in grid[0].indices.reversed()) {
        if (grid[grid.size - 1][c] == 'O' && !visited[grid.size - 1][c]) {
            traversDfs(Pair(grid.size - 1, c), grid, visited)
        }
    }

    // top
    for (r in grid.indices.reversed()) {
        if (grid[r][0] == 'O' && !visited[r][0]) {
            traversDfs(Pair(r, 0), grid, visited)
        }
    }

    grid.forEachIndexed { row, chars ->
        chars.forEachIndexed { column, c ->
            if (c == 'O' && !visited[row][column]) {
                output[row][column] = 'X'
            }
        }
    }

    return output

}

fun traversDfs(
    start: Pair<Int, Int>,
    grid: List<List<Char>>,
    visited: MutableList<MutableList<Boolean>>
) {
    visited[start.first][start.second] = true
    val upperNeighbour = getValidUpperNeighbour2(start.first, start.second, grid, visited)
    val downNeighbour = getValidDownWardNeighbour2(start.first, start.second, grid, visited)
    val leftNeighbour = getValidLeftNeighbour2(start.first, start.second, grid, visited)
    val rightNeighbour = getValidRightNeighbour2(start.first, start.second, grid, visited)
    upperNeighbour?.let {
        traversDfs(it, grid, visited)
    }

    downNeighbour?.let {
        traversDfs(it, grid, visited)
    }

    leftNeighbour?.let {
        traversDfs(it, grid, visited)
    }
    rightNeighbour?.let {
        traversDfs(it, grid, visited)
    }

}

fun getValidUpperNeighbour2(
    r: Int,
    c: Int,
    grid: List<List<Char>>,
    visited: MutableList<MutableList<Boolean>>
): NodeC? {
    return if ((r - 1) in grid.indices && !visited[r - 1][c] && grid[r - 1][c] == 'O')
        return NodeC(r - 1, c)
    else null
}

fun getValidDownWardNeighbour2(
    r: Int,
    c: Int,
    grid: List<List<Char>>,
    visited: MutableList<MutableList<Boolean>>
): NodeC? {
    return if ((r + 1) in grid.indices && !visited[r + 1][c] && grid[r + 1][c] == 'O')
        return NodeC(r + 1, c)
    else null
}

fun getValidLeftNeighbour2(r: Int, c: Int, grid: List<List<Char>>, visited: MutableList<MutableList<Boolean>>): NodeC? {
    return if ((c - 1) in grid[0].indices && !visited[r][c - 1] && grid[r][c - 1] == 'O')
        return NodeC(r, c - 1)
    else null
}

fun getValidRightNeighbour2(
    r: Int,
    c: Int,
    grid: List<List<Char>>,
    visited: MutableList<MutableList<Boolean>>
): NodeC? {
    return if ((c + 1) in grid[0].indices && !visited[r][c + 1] && grid[r][c + 1] == 'O')
        return NodeC(r, c + 1)
    else null
}