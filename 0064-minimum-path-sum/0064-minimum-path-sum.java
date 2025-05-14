class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(grid.length-1,grid[0].length-1,grid,dp);
    }
    int f(int i , int j,int[][] grid,int[][] dp){
        if(i == 0 && j == 0){
            return grid[0][0];
        }
        if(i < 0 || j < 0) return Integer.MAX_VALUE-201;
        if(dp[i][j] != -1) return dp[i][j];
        int left = grid[i][j] + f(i-1,j,grid,dp);
        int right = grid[i][j] + f(i,j-1,grid,dp);
        return dp[i][j] = Math.min(left,right);
    }
}