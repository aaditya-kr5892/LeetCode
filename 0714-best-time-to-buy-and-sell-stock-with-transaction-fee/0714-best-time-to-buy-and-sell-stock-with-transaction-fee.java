class Solution {
    public int maxProfit(int[] prices, int fee) {
        int dp[][] = new int[prices.length][2];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(0,1,prices,fee,dp);
    }
    int f(int i, int buy, int[]prices,int fee,int[][] dp){
        if(i >= prices.length){
            return 0;
        }
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 1){
            return dp[i][buy] = Math.max(-prices[i]+f(i+1,0,prices,fee,dp),f(i+1,1,prices,fee,dp));
        }
        else{
            return dp[i][buy] = Math.max(prices[i]-fee+f(i+1,1,prices,fee,dp),f(i+1,0,prices,fee,dp));
        }
    }
}