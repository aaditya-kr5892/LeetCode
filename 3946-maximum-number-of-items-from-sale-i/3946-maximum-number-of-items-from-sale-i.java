class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int it[][] = new int[items.length][3];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < items.length ; i++){
            it[i][0] = items[i][0];
            it[i][1] = items[i][1];
            min = Math.min(min, items[i][1]);
            for(int j = 0 ; j < items.length ; j++){
                if(i == j) continue;
                if(items[j][0] % items[i][0] == 0) it[i][2]++;
            }
        }
        int n = budget/min;
        int dp[][] = new int[items.length][budget+1];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        // Arrays.sort(it, (a, b)->Integer.compare(a[1], b[1]));
        return f(it, 0, budget, dp, min);
    }
    int f(int[][] items, int ind, int b, int[][] dp, int min){
        if(ind == items.length) return b/min;
        if(dp[ind][b] != -1) return dp[ind][b];
        int nt = f(items, ind + 1, b, dp, min);
        
        int take = 0;
        if(b >= items[ind][1]){
            int value = 1 + items[ind][2]; 
            take = value + f(items, ind + 1, b - items[ind][1], dp, min);
        }
        return dp[ind][b] = Math.max(take, nt);
    }
}