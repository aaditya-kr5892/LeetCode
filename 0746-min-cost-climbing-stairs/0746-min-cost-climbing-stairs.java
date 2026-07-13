class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);

        // return Math.min(f(cost, 0, dp), f(cost, 1, dp));

        dp[cost.length] = 0;
        for(int i = cost.length-1 ; i>= 0 ; i--){
            int take1 = cost[i] + dp[i+1];
            int take2 = Integer.MAX_VALUE;
            if(i + 2 <= cost.length){
                take2 = cost[i] + dp[i+2];
            }
            dp[i] = Math.min(take1, take2);
        }
        return Math.min(dp[0], dp[1]);
    }
    int f(int []cost, int ind, int[] dp){
        if(ind >= cost.length) return 0;
        if(dp[ind] != -1) return dp[ind];
        int take1 = cost[ind] + f(cost, ind+1, dp);
        int take2 = cost[ind] + f(cost, ind+2, dp);
        return dp[ind] = Math.min(take1, take2);
    }
}