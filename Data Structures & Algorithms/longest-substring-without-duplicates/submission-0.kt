class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val lastSeenIndex = HashMap<Char, Int>()
        var startIndex = 0
        var maxLength = 0

        for (i in s.indices) {
            val ch = s[i]

            if (lastSeenIndex.containsKey(ch)) {
                startIndex = maxOf(
                    startIndex,
                    lastSeenIndex[ch]!! + 1
                )
            }

            lastSeenIndex[ch] = i
            maxLength = maxOf(maxLength, i - startIndex + 1)
        }

        return maxLength
    }
}