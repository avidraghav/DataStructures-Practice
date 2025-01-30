package graph

fun main() {
    val oranges = listOf(listOf(2, 1, 1), listOf(0, 1, 1), listOf(1, 0, 1))
    val mutableOranges = MutableList(oranges.size) {
        MutableList(oranges.size) {
            0
        }
    }
    val rottenOranges = MutableList((oranges.size * oranges.size)) {
    }

    var i = 0
    var j = 0
    oranges.forEach { row ->
        row.forEach { orangeInEachRow ->
            mutableOranges[i][j] = orangeInEachRow
            j++
        }
        i++
        j = 0
    }

    i = 0
    j = 0
    mutableOranges.forEach { row ->
        row.forEach { currentOrange ->
            print(currentOrange)
            if (currentOrange == 2) {
                if (i + 1 < mutableOranges.size && j + 1 < mutableOranges.size) {
                    if (mutableOranges[i + 1][j + 1] == 1) {
                        mutableOranges[i + 1][j + 1] = 2
                    }
                }

            }
        }
        println()
    }

}