class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = position.indices
            .map{i->
                Pair(position[i], (target-position[i]).toDouble()/speed[i])
            }
            .sortedByDescending{it.first}

        var fleets = 0
        var slowestTimeAhead = 0.0
        for((_, time) in cars){
            if(time>slowestTimeAhead){
                fleets++
                slowestTimeAhead = time
            }
        }

        return fleets
    }
}
