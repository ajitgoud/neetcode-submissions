class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if(nums.size == k) return nums
        val freq = HashMap<Int, Int>()

        for(num in nums){
            freq[num] = freq.getOrDefault(num, 0)+ 1
        }

        val buckets = Array(nums.size + 1){ mutableListOf<Int>() }

        for((num, count) in freq){
            buckets[count].add(num)
        }

        val result = IntArray(k)
        var resIndex = 0
        for(count in nums.size downTo 1){
            for(num in buckets[count]){
                result[resIndex++] = num
                if(resIndex==k){
                    return result
                }
            }
        }
        return result
    }
}