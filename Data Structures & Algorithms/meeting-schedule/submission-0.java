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
    public boolean canAttendMeetings(List<Interval> intervals) {
        boolean canAttend = true;

        if (intervals.isEmpty()) {
            return canAttend;
        }

        Collections.sort(intervals, Comparator.comparingInt(interval -> interval.start));

        int currentStart = intervals.get(0).start;
        int currentEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            if (currentEnd > intervals.get(i).start) {
                return false;
            } else {
                currentStart = intervals.get(i).start;
                currentEnd = intervals.get(i).end;
            }
        }

        return canAttend;
    }
}
