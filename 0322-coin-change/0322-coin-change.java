class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[amount+1][coins.length+1];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        int res = f(coins, amount, 0, dp);
        return (res == (int)1e9)?-1:res;
    }
    int f(int[] coins, int amount, int ind, int[][] dp){
        if(amount == 0) return 0;
        if(ind == coins.length-1){
            if(amount % coins[ind] == 0) return amount/coins[ind];
            else return (int)1e9;
        }

        if(dp[amount][ind] != -1) return dp[amount][ind];

        int t = (int)1e9;
        if(amount >= coins[ind]){
            t = 1+f(coins, amount-coins[ind], ind, dp);
        }
        int nt = f(coins, amount, ind+1, dp);
        return dp[amount][ind] = Math.min(t, nt);
    }
}