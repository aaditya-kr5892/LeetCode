class Solution {
    public int maxProfit(int[] prices) {
        int prev[][] = new int[2][3];
        int curr[][] = new int[2][3];
        // int dp[][][] = new int[prices.length+1][2][3];
        
        for(int i = prices.length-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < 2 ; j++){
                for(int k = 1 ; k >= 0 ; k--){
                    if(j == 1){
                        curr[j][k] = Math.max(-prices[i] +prev[0][k], prev[1][k]);
                    }
                    else{
                        curr[j][k] = Math.max(prices[i]+prev[1][k+1],prev[0][k]);
                    }
                }
            }
            prev = curr;
        }
        return prev[1][0];
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