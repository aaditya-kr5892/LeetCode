class Solution {
    public boolean isMatch(String s, String p) {
        int dp[][] = new int[s.length()][p.length()];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(s.length()-1,p.length()-1,s,p,dp);
    }
    boolean f(int i, int j, String s, String p, int[][] dp){
        if(i < 0 && j < 0) return true;
        if(j < 0 && i >= 0){
            return false;
        }
        if(i < 0 && j >=0){
            for(int i1 = 0 ; i1 <= j ; i1++){
                if(p.charAt(i1) != '*')
                return false;
            }
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j]==1;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            dp[i][j] = f(i - 1, j - 1, s, p, dp) ? 1 : 0;
            return dp[i][j] == 1;
        }
        
        if(p.charAt(j) == '*'){
            dp[i][j] = (f(i - 1, j, s, p, dp) || f(i, j - 1, s, p, dp)) ? 1 : 0;
            return dp[i][j] == 1;
        }
        return false;
    }
}