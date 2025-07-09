class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length+1][2][3];
        
        for(int i = prices.length-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < 2 ; j++){
                for(int k = 1 ; k >= 0 ; k--){
                    if(j == 1){
                        dp[i][j][k] = Math.max(-prices[i] + dp[i+1][0][k], dp[i+1][1][k]);
                    }
                    else{
                        dp[i][j][k] = Math.max(prices[i]+dp[i+1][1][k+1],dp[i+1][0][k]);
                    }
                }
            }
        }
        return dp[0][1][0];
    }
    int f(int i, int buy, int tran,int prices[],int[][][] dp){
        if(i == prices.length){
            return 0;
        }
        if(tran == 2){
            return 0;
        }
        if(dp[i][buy][tran] != -1) return dp[i][buy][tran];
        if(buy == 1){
            return dp[i][buy][tran] = Math.max(-prices[i]+f(i+1,0,tran,prices,dp), f(i+1,1,tran,prices,dp));
        }
        else{
            return dp[i][buy][tran] = Math.max(prices[i]+f(i+1 ,1 ,tran+1 ,prices,dp), f(i+1, 0, tran, prices,dp));
        }
    }
}