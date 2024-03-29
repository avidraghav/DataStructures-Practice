fun main() {
//    val citations = intArrayOf(3, 0, 6, 1, 5)
    val citations = intArrayOf(1, 3, 1)
    println(hIndex(citations))
}

// incomplete
// naive O(n^2)
fun hIndex(citations: IntArray): Int {

    if (citations.size == 1 ) {
        return if(citations[0]!=0) 1 else 0
    }
    var i = 0
    var j = 0
    var hIndex = 0
    var maxHIndex = 0
    var currentCitations = 0
    var maxCitations = 0
    while (i < citations.size) {
        hIndex = citations[i]
        while (j < citations.size) {
            if (citations[j] != 0) {
                if (citations[i] <= citations[j]) {
                    currentCitations++
                }
            }
            j++
        }
        if (currentCitations > maxCitations && hIndex > maxHIndex) {
            maxCitations = currentCitations
            maxHIndex = hIndex
        }
        currentCitations = 0
        j = 0
        i++
    }

    return maxHIndex
}