class Solution {
    public int maxProfit(int[] prices) {
        int dp[][][] = new int[prices.length][2][2];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < 2 ; j++){
                for(int k = 0 ; k < 2 ; k++){
                    dp[i][j][k] = -1;
                }
            }
        }
        return f(0,1,0,prices,dp);
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