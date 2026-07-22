class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount+1];
        // Arrays.fill(dp, -1);
        for(int i = 0 ; i < dp.length ; i++){
            Arrays.fill(dp[i], -1);
        }
        return f(0, coins, amount, dp);
    }
    int f(int i, int[] amount, int am, int[][] dp){
        if(i == amount.length){
            return (am == 0)?1:0;
        }
        if(dp[i][am] != -1) return dp[i][am];
        int take = 0;
        if(amount[i] <= am)
        take = f(i, amount, am-amount[i], dp);

        int not = f(i+1, amount, am, dp);
        return dp[i][am] = take+not;
    }
}