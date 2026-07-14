class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }

        // return f(grid, 0, 0, dp);

        dp[grid.length-1][grid[0].length-1] = grid[grid.length-1][grid[0].length-1];

        for(int i = grid.length-1 ; i >= 0 ; i--){
            for(int j = grid[0].length-1 ; j >= 0 ; j--){

                if(i == grid.length-1 && j == grid[0].length-1) continue;

                int d = Integer.MAX_VALUE, r = Integer.MAX_VALUE;
                if(i + 1 < grid.length){
                    d = grid[i][j] + dp[i+1][j];
                }
                if(j + 1 < grid[0].length){
                    r = grid[i][j] + dp[i][j+1];
                }
                dp[i][j] = Math.min(r, d);
            }
        }
        return dp[0][0];
    }
    int f(int[][] grid, int i, int j, int[][] dp){
        if(i >= grid.length) return Integer.MAX_VALUE;
        if(j >= grid[0].length) return Integer.MAX_VALUE;
        if(i == grid.length-1 && j == grid[0].length-1){
            return grid[i][j];
        }
        if(dp[i][j] != -1 ) return dp[i][j];

        int r = Integer.MAX_VALUE;
        int d = Integer.MAX_VALUE;

        if(i +1 < grid.length){
            d = grid[i][j] + f(grid, i+1, j, dp);
        }
        if(j + 1 < grid[0].length){
            r = grid[i][j] + f(grid, i, j+1, dp);
        }
        return dp[i][j] = Math.min(d, r);
    }
}