class Solution {
    public int cherryPickup(int[][] grid) {
        int dp[][][] = new int[grid.length][grid[0].length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                for(int k = 0 ; k < grid[0].length ; k++){
                    dp[i][j][k] = Integer.MIN_VALUE;
                }
            }
        }
        return f(0,0,grid[0].length-1,grid,dp);
    }
    int f(int i , int j1, int j2 , int[][] grid,int[][][] dp){
        if(i >= grid.length || j1 >= grid[0].length || j2>= grid[0].length || j2 < 0 || j1< 0){
            return Integer.MIN_VALUE+101;
        }
        if(i == grid.length-1){
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1]+grid[i][j2];
        }
        int [] d = {-1,0,1};
        int maxi = Integer.MIN_VALUE;
        if(dp[i][j1][j2] != Integer.MIN_VALUE) return dp[i][j1][j2];
        for(int i1 = 0 ; i1 < d.length ; i1++){
            for(int j = 0 ; j < d.length ; j++){
                if(j1 == j2){
                    maxi = Math.max(maxi,grid[i][j1] + f(i+1,j1 + d[i1] , j2+ d[j],grid,dp));
                }
                else{
                    maxi = Math.max(maxi,grid[i][j1] + grid[i][j2] + f(i+1,j1+d[i1],j2+d[j],grid,dp));
                }
                
            }
        }
        return dp[i][j1][j2] = maxi;
    }
}