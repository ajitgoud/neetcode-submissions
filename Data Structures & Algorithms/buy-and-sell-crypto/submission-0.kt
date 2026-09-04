class Solution {
    fun maxProfit(prices: IntArray): Int {
        var lowPrice = Integer.MAX_VALUE
        var maxProfit = 0
        for(price in prices){
            lowPrice = minOf(price, lowPrice)
            maxProfit = maxOf(maxProfit, price - lowPrice)
        }

        return maxProfit
    }
}
