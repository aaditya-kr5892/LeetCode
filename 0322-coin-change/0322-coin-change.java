class Solution {
    public int coinChange(int[] coins, int amount) {
        // int min[] = new int[1];
        // min[0] = Integer.MAX_VALUE;
        int dp[][] = new int[coins.length][amount+1];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        int min = f(coins, amount, 0, dp);
        return min==Integer.MAX_VALUE?-1:min;

    }
    int f(int[] coins, int amount, int i, int[][] dp){
        if(amount == 0){
            // min[0] = Math.min(min[0], num);
            return 0;
        }
        if(i == coins.length){
            // min[0] = Math.min(min[0], num);
            return Integer.MAX_VALUE;
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        int take = Integer.MAX_VALUE;
        if(coins[i] <= amount){
            int t = f(coins, amount-coins[i], i, dp);
            take = 1 + ((t==Integer.MAX_VALUE)?Integer.MAX_VALUE-1:t);
        }
        int notTake = f(coins, amount, i+1, dp);

        return dp[i][amount] = Math.min(take, notTake);
    }
}