class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        int removeCount = 0;

        for (int i = 1; i < intervals.length; i++) {
            if (currentEnd > intervals[i][0]) {
                removeCount++;
                currentEnd = Math.min(currentEnd, intervals[i][1]);
            } else {
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            }
        }

        return removeCount;
    }
}
