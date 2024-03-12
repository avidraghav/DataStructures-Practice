fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(prices))
}


fun maxProfit(prices: IntArray): Int {
    var i = 0
    var j = i + 1
    var profit = 0
    var maxProfit = 0

    while (j < prices.size) {
        if (prices[j] < prices[i]) {
            i = j
            j = i + 1
        } else {
            profit = prices[j] - prices[i]
            if (profit > maxProfit) {
                maxProfit = profit
            }
            j++
        }
    }
    return maxProfit
}