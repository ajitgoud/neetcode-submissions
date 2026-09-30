class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        for(char task:tasks){
            freq[task-'A']++;
        }
        for(int count:freq){
            if(count>0){
                maxHeap.offer(count);
            }
        }

        Queue<int[]> queue = new ArrayDeque();
        int time=0;

        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time++;
            if(!queue.isEmpty() && queue.peek()[1]==time){
                maxHeap.offer(queue.poll()[0]);
            }

            if(!maxHeap.isEmpty()){
                int count = maxHeap.poll();
                count--;
                if(count>0){
                    queue.offer(new int[]{count, time+n+1});
                }
            }
        }

        return time;
    }
}
