class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int dp[][] = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i = 0; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(obstacleGrid.length-1,obstacleGrid[0].length-1,dp,obstacleGrid);
    }
    int f(int i , int j,int dp[][],int obstacle[][]){
        if(obstacle[i][j] == 1) return 0;
        if(i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int left = 0 , right = 0;
        if(j > 0 && obstacle[i][j-1] == 0)
        left = f(i,j-1,dp,obstacle);
        if(i > 0 && obstacle[i-1][j] == 0)
        right = f(i-1,j,dp,obstacle);
        return dp[i][j] = left+right;
    }
}