class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var start = 0
        var end = numbers.lastIndex

        while(start<end){
            val sum = numbers[start]+numbers[end]
            if(sum==target){
                return intArrayOf(start+1, end+1)
            }else if(sum>target){
                end--
            }else{
                start++
            }
        }

        return intArrayOf(0,0)
    }
}
