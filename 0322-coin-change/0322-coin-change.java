class Solution {
    public int coinChange(int[] coins, int amount) {
        int dp[][] = new int[coins.length][amount+1];
        for(int i = 0 ; i < coins.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        int res = f(coins.length-1,coins,amount,dp) ;
        if(res == (int)1e9)
        return -1;
        else
        return res;
    }
    int f(int ind,int []coins, int amount,int [][]dp){
        if(amount == 0)
        return 0;
        if(ind == 0){
            if(coins[ind] <= amount){
                if(amount % coins[ind] == 0)
                return amount/coins[ind];
                else
                return (int)1e9;
            }
            else
            return (int)1e9;
        }
        if(dp[ind][amount] != -1) return dp[ind][amount];
        int not = f(ind-1,coins,amount,dp);
        int take = (int)1e9;
        if(coins[ind] <= amount){
            take = 1 + f(ind , coins,amount-coins[ind],dp);
        }
        return dp[ind][amount] = Math.min(take,not);
    }
}