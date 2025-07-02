class Solution {
    public int minInsertions(String s) {
        int dp[][] = new int[s.length()][s.length()];
        
        for(int i = s.length()-1 ; i >= 0 ; i--){
            for(int j = 0 ; j < dp.length ; j++){
                if(j > i){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = dp[i+1][j-1];
                    }
                    else{
                        dp[i][j] = 1+ Math.min(dp[i+1][j],dp[i][j-1]);
                    }
                }
            }
        }
        return dp[0][s.length()-1];
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