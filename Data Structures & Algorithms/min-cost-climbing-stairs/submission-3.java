class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        int prev2 = cost[0];
        int prev = cost[1];

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(prev, prev2);
            prev2 = prev;
            prev = current;
        }

        return Math.min(prev2, prev);
    }
}
