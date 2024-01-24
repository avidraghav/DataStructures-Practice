fun main() {
//    val s = "aeiou"
//    val k = 2
    val s = "abciiidef"
    val k = 3
    println(maxVowels(s, k))
}
// O(s.length)
fun maxVowels(s: String, k: Int): Int {
    var i = 0
    var j = i + k - 1
    var count = 0
    if (s.length <= k) {
        for (c in s) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++
            }
        }
        return count
    } else {
        for (v in i..j) {
            if (s[v] == 'a' || s[v] == 'e' || s[v] == 'i' || s[v] == 'o' || s[v] == 'u') {
                count++
            }
        }
        var ncount = count
        var countToBeDecreased: Int
        var countToBeIncreased: Int
        i++
        j++
        while (j < s.length) {
            countToBeDecreased =
                if (s[i - 1] == 'a' || s[i - 1] == 'e' || s[i - 1] == 'i' || s[i - 1] == 'o' || s[i - 1] == 'u') 1 else 0
            countToBeIncreased = if (s[j] == 'a' || s[j] == 'e' || s[j] == 'i' || s[j] == 'o' || s[j] == 'u') 1 else 0
            ncount = ncount - countToBeDecreased + countToBeIncreased
            if (ncount > count) {
                count = ncount
            }
            i++
            j++
        }
    }
    return count
}