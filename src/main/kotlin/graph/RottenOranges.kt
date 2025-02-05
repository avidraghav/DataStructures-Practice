package graph

import java.util.*

fun main() {
//    val mutableOranges = mutableListOf(
//        mutableListOf(0, 1, 2),
//        mutableListOf(0, 1, 1),
//        mutableListOf(2, 0, 1)
//    )

//    val mutableOranges = mutableListOf(
//        mutableListOf(2, 1, 1),
//        mutableListOf(1, 1, 0),
//        mutableListOf(0, 1, 1)
//    )

    val mutableOranges = mutableListOf(
        mutableListOf(1, 2, 1),
        mutableListOf(1, 1, 0),
        mutableListOf(0, 0, 1)
    )

    val time = getTimeToRotAllFreshOranges(mutableOranges)
    println(time)

}

typealias OrangeWithTime = Triple<Int, Int, Int>

fun getTimeToRotAllFreshOranges(orangeBasket: MutableList<MutableList<Int>>): Int {
    var time = 0
    val q = ArrayDeque<OrangeWithTime>()

    // add initial rotten oranges to Q
    var i = 0
    var j = 0
    orangeBasket.forEach { row ->
        row.forEach { orange ->
            if (orange == 2) {
                q.add(OrangeWithTime(i, j, time))
            }
            j++
        }
        i++
        j = 0
    }


    while (q.isNotEmpty()) {
        getLeftRottenOrange(q.first, orangeBasket)?.let {
            time = it.third
            q.add(it)
        }
        getRightRottenOrange(q.first, orangeBasket)?.let {
            time = it.third
            q.add(it)
        }
        getUpperRottenOrange(q.first, orangeBasket)?.let {
            time = it.third
            q.add(it)
        }
        getLowerRottenOrange(q.first, orangeBasket)?.let {
            time = it.third
            q.add(it)
        }

        q.remove()

    }

    orangeBasket.forEach { row ->
        row.forEach { orange ->
            if (orange == 1) {
                return -1
            }
        }
    }

    return time
}

fun getLeftRottenOrange(
    source: OrangeWithTime,
    orangeBasket: MutableList<MutableList<Int>>
): OrangeWithTime? {
    val c = (source.second - 1)
    return if (c in orangeBasket.indices && orangeBasket[source.first][c] == 1) {
        orangeBasket[source.first][c] = 2
        OrangeWithTime(source.first, c, source.third + 1)
    } else
        null
}

fun getRightRottenOrange(
    source: OrangeWithTime,
    orangeBasket: MutableList<MutableList<Int>>
): OrangeWithTime? {
    val c = (source.second + 1)
    return if (c in orangeBasket.indices && orangeBasket[source.first][c] == 1) {
        orangeBasket[source.first][c] = 2
        OrangeWithTime(source.first, c, source.third + 1)
    } else
        null
}

fun getUpperRottenOrange(
    source: OrangeWithTime,
    orangeBasket: MutableList<MutableList<Int>>
): OrangeWithTime? {
    val r = (source.first - 1)
    return if (r in orangeBasket[0].indices && orangeBasket[r][source.second] == 1) {
        orangeBasket[r][source.second] = 2
        OrangeWithTime(r, source.second, source.third + 1)
    } else
        null
}

fun getLowerRottenOrange(
    source: OrangeWithTime,
    orangeBasket: MutableList<MutableList<Int>>
): OrangeWithTime? {
    val r = (source.first + 1)
    return if (r in orangeBasket[0].indices && orangeBasket[r][source.second] == 1) {
        orangeBasket[r][source.second] = 2
        OrangeWithTime(r, source.second, source.third + 1)
    } else
        null
}





