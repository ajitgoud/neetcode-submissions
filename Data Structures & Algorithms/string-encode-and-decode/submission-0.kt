class Solution {

    fun encode(strs: List<String>): String {
        if(strs.isEmpty()) return ""
        val list = mutableListOf<String>()
        for(str in strs){
            list.add("${str.length}#${str}")
        }
        return list.joinToString("")
    }

    fun decode(str: String): List<String> {
        if(str.isEmpty()) return listOf()
        val result = mutableListOf<String>()
        var i = 0
        while(i<str.length){
            val hashIndex = str.indexOf("#", i)
            val len = str.substring(i, hashIndex).toInt()
            val wordStart = hashIndex+1
            val wordEnd = wordStart + len
            result.add(str.substring(wordStart, wordEnd))
            i = wordEnd
        }
        return result
    }
}
