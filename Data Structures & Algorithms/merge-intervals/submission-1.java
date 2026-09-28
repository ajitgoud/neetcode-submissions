class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][];
        }

        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int currentStart = intervals[0][0];
        int currentEnd = intervals[0][1];
        int n = intervals.length;

        for (int i = 1; i < n; i++) {
            if (currentEnd >= intervals[i][0]) {
                currentStart = Math.min(currentStart, intervals[i][0]);
                currentEnd = Math.max(currentEnd, intervals[i][1]);
            } else {
                result.add(new int[] {currentStart, currentEnd});
                currentStart = intervals[i][0];
                currentEnd = intervals[i][1];
            }
        }
        result.add(new int[] {currentStart, currentEnd});
        return result.toArray(new int[result.size()][]);
    }
}
