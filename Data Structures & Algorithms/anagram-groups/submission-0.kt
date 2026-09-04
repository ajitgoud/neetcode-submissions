class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()

        for (str in strs) {
            val count = IntArray(26)

            for (ch in str) {
                count[ch - 'a']++
            }

            val key = count.joinToString("#")

            map.getOrPut(key) { mutableListOf() }.add(str)
        }

        return map.values.toList()
    }
}