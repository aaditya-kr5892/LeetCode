class Solution {
    public int numSubmat(int[][] mat) {
        int[][] dp = new int[mat.length][mat[0].length];

        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        int res = 0;
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                res +=f(i, j, mat, dp);
            }
        }
        return res ;
    }

    int f(int i, int j, int [][]mat, int[][] dp){
        if(i == mat.length || j == mat[0].length || mat[i][j] == 0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        int res = 0;
        for(int row = i; row < mat.length ; row++){
            int col = j;
            int width = 0;
            
            while(col < mat[0].length && mat[row][col] == 1){
                if(mat[row][col] == 1){
                    width++;
                    col++;
                }
                else
                break;
            }
            min = Math.min(min, width);
            res+=min;
        }
        return dp[i][j] = res;
    }
}