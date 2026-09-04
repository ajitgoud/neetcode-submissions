class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = piles.maxOrNull()!!

        while (left < right) {
            val mid = left + (right - left) / 2

            var hours = 0L
            for (pile in piles) {
                hours += (pile + mid - 1) / mid
            }

            if (hours <= h) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }
}