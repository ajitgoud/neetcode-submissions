/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.isEmpty()){
            return 0;
        }

        intervals.sort(Comparator.comparingInt(interval -> interval.start));
        int maxRooms = 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue();
        for(Interval interval:intervals){
            while(!minHeap.isEmpty() && minHeap.peek()<= interval.start){
                minHeap.poll();
            }
            minHeap.offer(interval.end);
            maxRooms = Math.max(maxRooms, minHeap.size());
        }

        return maxRooms;
    }
}
