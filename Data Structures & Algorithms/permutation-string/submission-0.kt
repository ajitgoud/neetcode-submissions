class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        if(s1.length>s2.length) return false
        val targetCount = IntArray(26)
        val windowCount = IntArray(26)

        for(i in s1.indices){
            targetCount[s1[i]-'a']++
            windowCount[s2[i]-'a']++
        }

        if(targetCount.contentEquals(windowCount)) return true

        for(right in s1.length until s2.length){
            val left = right-s1.length
            windowCount[s2[right]-'a']++
            windowCount[s2[left]-'a']--
            if(targetCount.contentEquals(windowCount)) return true
        }

        return false
    }
}
