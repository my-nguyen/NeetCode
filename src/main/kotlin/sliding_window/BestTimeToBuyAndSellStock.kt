package sliding_window

fun main() {
    val list = listOf(intArrayOf(7,1,5,3,6,4), intArrayOf(7,6,4,3,1), intArrayOf(2,4,1), intArrayOf(2,1,2,1,0,1,2))
    for (prices in list) {
        println("prices: ${prices.contentToString()}, best time to buy and sell stock: ${bestTimeToBuyAndSellStock(prices)}")
    }
}

fun bestTimeToBuyAndSellStock(prices: IntArray): Int {
    var buy = Int.MAX_VALUE
    var profit = 0
    for (price in prices) {
        if (price < buy) {
            buy = price
        } else if (price - buy > profit) {
            profit = price - buy
        }
    }
    return profit
}