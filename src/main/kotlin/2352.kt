fun main() {
    //val grid = arrayOf(intArrayOf(3, 2, 1), intArrayOf(1, 7, 6), intArrayOf(2, 7, 7))
    val grid = arrayOf(intArrayOf(3, 1, 2, 2), intArrayOf(1, 4, 4, 5), intArrayOf(2, 4, 2, 2), intArrayOf(2, 4, 2, 2))
    println(equalPairs(grid))
}

// O(n^3)
// compare each row with each column
//fun equalPairs(grid: Array<IntArray>): Int {
//    var elementIterator = 0
//    var rowMover = 0
//    var columnMover = 0
//
//    var rowI = 0
//    var rowJ = 0
//
//    var columnI = 0
//    var columnJ = 0
//    var count = 0
//
//    while (rowMover < grid.size) {
//        while (columnMover < grid.size) {
//            while (elementIterator < grid.size) {
//                if (grid[rowI][rowJ] == grid[columnI][columnJ]) {
//                    println("${grid[rowI][rowJ]} [${rowI}, $rowJ] == ${grid[columnI][columnJ]} [${columnI}, $columnJ]")
//                    rowJ++
//                    columnI++
//                    elementIterator++
//                    if (elementIterator == grid.size) {
//                        count++
//                    }
//                } else {
//                    println("${grid[rowI][rowJ]} [${rowI}, $rowJ] != ${grid[columnI][columnJ]} [${columnI}, $columnJ]")
//                    break
//                }
//            }
//            elementIterator = 0
//            columnMover++
//            columnI = 0
//            columnJ++
//            rowJ = 0
//        }
//        columnMover = 0
//        rowMover++
//        columnI = 0
//        columnJ = 0
//        rowI++
//        rowJ = 0
//    }
//    return count
//}

// Time- O(n^2) Space- O(number of rows or column)
fun equalPairs(grid: Array<IntArray>): Int {
    var count = 0
    val rowMap: MutableMap<Int, String> = mutableMapOf()
    val columnMap: MutableMap<Int, String> = mutableMapOf()
    val hashBuilder = StringBuilder()

    // hashes for rows
    grid.forEachIndexed { index, arr ->
        for (n in arr) {
            hashBuilder.append(n)
            hashBuilder.append("_")
        }
        rowMap[index] = hashBuilder.toString()
        hashBuilder.clear()
    }

    // hashes for columns
    for (i in grid.indices) {
        grid.forEachIndexed { index, _ ->
            hashBuilder.append(grid[index][i])
            hashBuilder.append("_")
        }
        columnMap[i] = hashBuilder.toString()
        hashBuilder.clear()
    }

    for ((_, rowHash) in rowMap) {
        for ((_, columnHash) in columnMap) {
            if (rowHash == columnHash)
                count++
        }
    }
    return count
}