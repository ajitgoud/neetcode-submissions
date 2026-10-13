class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();

        PriorityQueue<Integer> minHeap =
            new PriorityQueue((a, b) -> Integer.compare(freq.get(a), freq.get(b)));

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        for (int num : freq.keySet()) {
            minHeap.offer(num);

            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = minHeap.poll();
        }

        return result;
    }
}
