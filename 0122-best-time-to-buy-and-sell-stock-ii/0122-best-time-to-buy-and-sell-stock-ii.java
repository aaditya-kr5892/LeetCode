class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(0,1,prices,dp);
    }
    int f(int i, int buy, int[] price,int [][]dp){
        if(i >= price.length){
            return 0;
        }
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 1){
            dp[i][buy] = Math.max(-price[i]+f(i+1,0,price,dp),f(i+1,1,price,dp));
        }
        else{
            dp[i][buy] = Math.max(price[i] + f(i+1,1,price,dp),f(i+1,0,price,dp));
        }
        return dp[i][buy];
    }
}