fun main() {
    val prices = intArrayOf(7,1,5,3,6,4)
    println(maxProfit2(prices))
}

fun maxProfit2(prices: IntArray): Int {
    var buy = 0
    var sell = buy + 1
    var profit = 0
    while (sell < prices.size) {
        if (prices[sell] <= prices[buy]) {
            buy = sell
            sell = sell + 1
        } else {
            profit = profit + (prices[sell] - prices[buy])
            buy++
            sell++
        }
    }
    return profit
}