class Solution {
    fun maxArea(heights: IntArray): Int {
        var start = 0
        var end = heights.lastIndex
        var area = 0
        while(start<end){
            area = maxOf(area, minOf(heights[start], heights[end]) * (end - start))
            if(heights[start]> heights[end]){
                end--
            }else{
                start++
            }
        }

        return area
        

    }
}
