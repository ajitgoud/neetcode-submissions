class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());

        for (int stone : stones) {
            maxHeap.offer(stone);
        }

        while (maxHeap.size() > 1) {
            var y = maxHeap.poll();
            var x = maxHeap.poll();
            if(y!=x){
                maxHeap.offer(y-x);
            }
        }

        if (maxHeap.size() == 1) {
            return maxHeap.peek();
        } else
            return 0;
    }
}
