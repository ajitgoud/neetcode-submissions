class TimeMap() {

     data class Entry(val timestamp: Int, val value: String)

    private val map = HashMap<String, MutableList<Entry>>()

    fun set(key: String, value: String, timestamp: Int) {
        map.getOrPut(key){mutableListOf()}
            .add(Entry(timestamp, value))

    }

    fun get(key: String, timestamp: Int): String {
        val list = map[key] ?: return ""
        var left = 0
        var right = list.lastIndex
        var ans = ""
        while(left<=right){
            val mid = left + (right-left)/2
            if(list[mid].timestamp<=timestamp){
                ans = list[mid].value
                left = mid+1
            }else{
                right = mid-1
            }
        }

        return ans

    }
}
