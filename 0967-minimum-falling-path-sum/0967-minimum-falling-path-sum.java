class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < matrix[matrix.length-1].length ; i++){
            min = Math.min(min,f(matrix.length-1,i,matrix,dp));
        }
        return min;
    }
    int f(int i, int j, int matrix[][] , int dp[][]){
        if(i == 0){
            return matrix[i][j];
        }
        if(dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
        if(i > 0 && j > 0){
            left = matrix[i][j] + f(i-1,j-1,matrix,dp);
        }
        if(i > 0 && j < matrix[i].length-1){
            right = matrix[i][j] + f(i-1,j+1,matrix,dp);
        }
        if(i > 0){
            top = matrix[i][j] + f(i-1,j,matrix,dp);
        }
        return dp[i][j] = Math.min(left,Math.min(right,top));
    }
}