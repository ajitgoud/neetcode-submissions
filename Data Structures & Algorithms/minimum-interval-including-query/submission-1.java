class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, Comparator.comparingInt(a -> a[0]));

        int[] result = new int[queries.length];

        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int intervalIndex = 0;

        for (int[] query : sortedQueries) {

            int q = query[0];

            while (intervalIndex < intervals.length
                    && intervals[intervalIndex][0] <= q) {

                int start = intervals[intervalIndex][0];
                int end = intervals[intervalIndex][1];

                int length = end - start + 1;

                minHeap.offer(new int[]{length, end});

                intervalIndex++;
            }

            while (!minHeap.isEmpty()
                    && minHeap.peek()[1] < q) {

                minHeap.poll();
            }

            if (!minHeap.isEmpty()) {
                result[query[1]] = minHeap.peek()[0];
            } else {
                result[query[1]] = -1;
            }
        }

        return result;
    }
}