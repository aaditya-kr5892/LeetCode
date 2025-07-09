class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+2][2];
        // int curr [] = new int[2];
        
        for(int i = prices.length-1 ; i >= 0 ; i--){
            // int curr [][] = new int[2][2];
            for(int j = 0 ; j < 2 ; j++){
                if(j ==1){
                    dp[i][j] = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    // if(i < prices.length-1)
                    dp[i][j] = Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
                    // else
                    // dp[i][j] = 0;
                }
            }
            // prev = curr;
        }
        return dp[0][1];
    }
    int f(int i, int buy, int[]prices,int[][] dp){
        if(i >= prices.length){
            return 0;
        }
        if(dp[i][buy] != -1) return dp[i][buy];
        if(buy == 1){
            return dp[i][buy] = Math.max(-prices[i]+f(i+1,0,prices,dp),f(i+1,1,prices,dp));
        }
        else{
            return dp[i][buy] = Math.max(prices[i]+f(i+2,1,prices,dp),f(i+1,0,prices,dp));
        }
    }
}