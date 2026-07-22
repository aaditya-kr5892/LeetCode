class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(0, 0, grid, dp);
    }
    int f(int i, int j, int[][] grid, int[][] dp){
        if(i >= grid.length || j >= grid[0].length){
            return 0;
        }
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }
        
        if(dp[i][j] != -1) return dp[i][j];

        int r = Integer.MAX_VALUE, d = Integer.MAX_VALUE;
        if(i + 1 < grid.length){
            d = grid[i][j] + f(i+1, j, grid, dp);
        }
        if(j + 1 < grid[0].length){
            r = grid[i][j] + f(i, j+1, grid, dp);
        }
        return dp[i][j] = Math.min(r, d);
    }
}