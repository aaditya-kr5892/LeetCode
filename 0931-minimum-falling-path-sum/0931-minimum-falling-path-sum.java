class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int dp[][] = new int[matrix.length][matrix[0].length];
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for(int i = 0 ; i < matrix[0].length ; i++){
            min = Math.min(min, f(0, i, matrix, dp));
        }
        return min;
    }

    int f(int r, int c, int matrix[][], int[][] dp){
        if(c == matrix[0].length) 
            return Integer.MAX_VALUE;

        if(r == matrix.length-1){
            return matrix[r][c];
        }

        if(dp[r][c] != Integer.MAX_VALUE){
            return dp[r][c];
        }

        
        int r1 = Integer.MAX_VALUE;
        int r2 = Integer.MAX_VALUE;
        int r3 = Integer.MAX_VALUE;

        if(r == matrix.length) return matrix[r][c];
        if(c > 0){
            r1 = f(r+1, c-1, matrix, dp);
        }
        if(c < dp.length-1){
            r2 = f(r+1, c+1, matrix, dp);
        }


        int min = Math.min(r1, Math.min(f(r+1, c, matrix, dp), r2));
        // sum+=min;
        return dp[r][c] = matrix[r][c]+ min;
        
    }
}