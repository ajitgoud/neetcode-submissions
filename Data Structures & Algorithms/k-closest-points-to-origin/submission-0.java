class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<double[]>(Comparator.comparingDouble((double[] a)-> a[0]).reversed());
        for(int[] point: points){
            double distance = Math.sqrt(point[0]*point[0]+point[1]*point[1]);
            System.out.println(distance +" - "+ point[0] + " - "+ point[1]);
            maxHeap.offer(new double[]{distance, point[0],point[1]});
            while(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()){
            double[] point = maxHeap.poll();
            result[i++]=new int[] {(int)point[1], (int)point[2]};
        }

        return result;

    }
}
