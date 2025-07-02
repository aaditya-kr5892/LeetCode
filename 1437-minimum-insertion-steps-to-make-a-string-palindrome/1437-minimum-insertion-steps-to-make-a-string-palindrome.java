class Solution {
    public int minInsertions(String s) {
        int dp[][] = new int[s.length()][s.length()];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(0,s.length()-1,s,dp);
    }
    int f(int i, int j , String s,int[][]dp){
        if(i >= j){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];

        if(s.charAt(i)== s.charAt(j)){
            return dp[i][j] = f(i+1,j-1,s,dp);
        }
        else{
            return dp[i][j] = 1 + Math.min(f(i+1,j,s,dp) , f(i,j-1,s,dp));
        }
    }
}