class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        
        int min = Integer.MAX_VALUE;
        for(int i =0 ; i < matrix[0].length ; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[i].length ; j++){
                int left = Integer.MAX_VALUE, top = Integer.MAX_VALUE, right = Integer.MAX_VALUE;
                if(i > 0 && j > 0){
                    left = matrix[i][j] + dp[i-1][j-1];
                }
                if(i > 0 && j < matrix[i].length-1){
                    right = matrix[i][j] + dp[i-1][j+1];
                }
                if(i > 0){
                    top = matrix[i][j] + dp[i-1][j];
                }
                dp[i][j] = Math.min(left,Math.min(right,top));
            }
        }
        for(int i = 0 ; i < matrix[matrix.length-1].length ; i++){
            min = Math.min(min,dp[matrix.length-1][i]);
        }
        return min;
    }
    
}