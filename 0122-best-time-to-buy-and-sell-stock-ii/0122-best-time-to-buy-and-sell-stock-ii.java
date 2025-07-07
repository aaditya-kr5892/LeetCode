class Solution {
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length+1][2];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        // int buy = 1;
        dp[prices.length][0] = 0;
        dp[prices.length][1] = 0;
        for(int i = prices.length-1 ; i >= 0 ; i--){
            for(int buy = dp[0].length-1 ; buy >=0 ; buy--){
                if(buy == 1){
                    dp[i][buy] = Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
                else{
                    dp[i][buy] = Math.max(prices[i] + dp[i+1][1],dp[i+1][0]);
                }
            }
        }

        return dp[0][1];
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