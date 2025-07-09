class Solution {
    public int maxProfit(int k, int[] prices) {
        int prev[][] = new int[2][k+1];
        int curr[][] = new int[2][k+1];
        // int dp[][][] = new int[prices.length+1][2][3];
        
        for(int i = prices.length-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < 2 ; j++){
                for(int k1 = k-1 ; k1 >= 0 ; k1--){
                    if(j == 1){
                        curr[j][k1] = Math.max(-prices[i] +prev[0][k1], prev[1][k1]);
                    }
                    else{
                        curr[j][k1] = Math.max(prices[i]+prev[1][k1+1],prev[0][k1]);
                    }
                }
            }
            prev = curr;
        }
        return prev[1][0];
    }
}