class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numbers = nums.toHashSet()
        var longest = 0
        for(num in numbers){
            if(!numbers.contains(num-1)){
                var current = num
                var length = 1
                while(numbers.contains(current+1)){
                    current++
                    length++
                }
                longest = maxOf(longest, length)
            }
        }
        return longest
    }
}
