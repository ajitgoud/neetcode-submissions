class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var count = IntArray(26)
        var maxFreq = 0
        var longest = 0
        var left = 0

        for(right in s.indices){
            val rightIndex = s[right]- 'A'
            count[rightIndex]++

            maxFreq = maxOf(maxFreq, count[rightIndex])
            while((right-left+1)-maxFreq>k){
                val leftIndex = s[left]-'A'
                count[leftIndex]--
                left++
            }
            longest = maxOf(longest, right-left+1)
        }

        return longest
    }
}
