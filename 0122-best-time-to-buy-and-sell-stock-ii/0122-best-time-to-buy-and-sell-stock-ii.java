class Solution {
    public int maxProfit(int[] prices) {
        int prev[] = new int[2];
        int curr[] = new int[2];
        int profit = 0;
        for(int i = prices.length-1 ; i >= 0 ; i--){
            for(int buy = 1 ; buy >=0 ; buy--){
                if(buy == 1){
                    profit = Math.max(-prices[i]+prev[0],prev[1]);
                }
                else{
                    profit = Math.max(prices[i] + prev[1],prev[0]);
                }
                curr[buy] = profit;
            }
            prev = curr;
        }

        return prev[1];
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