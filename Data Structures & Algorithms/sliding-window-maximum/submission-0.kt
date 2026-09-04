class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        if(nums.isEmpty() || k==0) return intArrayOf()

        val queue = ArrayDeque<Int>()
        val result = IntArray(nums.size-k+1)
        var resultIndex = 0

        for(right in nums.indices){
            while(queue.isNotEmpty() && queue.peekFirst()<=right-k){
                queue.pollFirst()
            }

            while(queue.isNotEmpty() && nums[queue.peekLast()]<=nums[right]){
                queue.pollLast()
            }

            queue.offerLast(right)

            if(right>=k-1){
                result[resultIndex++] = nums[queue.peekFirst()]
            }
        }
        return result
    }
}
