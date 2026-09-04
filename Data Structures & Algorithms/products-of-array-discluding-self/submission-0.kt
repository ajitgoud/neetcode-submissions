class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val result = IntArray(nums.size)

        var leftProduct = 1
        for (i in nums.indices) {
            result[i] = leftProduct
            leftProduct *= nums[i]
        }

        var rightProduct = 1
        for (i in nums.lastIndex downTo 0) {
            result[i] *= rightProduct
            rightProduct *= nums[i]
        }

        return result
    }
}