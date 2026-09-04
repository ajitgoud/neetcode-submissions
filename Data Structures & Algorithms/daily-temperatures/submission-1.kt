class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()

        for(i in temperatures.indices){
            while(stack.isNotEmpty() && temperatures[i]>temperatures[stack.last()]){
                val lastIndex = stack.removeLast()
                result[lastIndex] = i-lastIndex
            }
            stack.addLast(i)
        }

        return result
    }
}
