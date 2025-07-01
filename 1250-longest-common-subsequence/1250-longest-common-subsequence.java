class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length()+1][text2.length()+1];
        for(int i = 1 ; i < dp.length ; i++){
            for(int j = 1 ; j < dp[0].length ; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1))
                dp[i][j] = 1+dp[i-1][j-1];
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        // int res = f(text1.length()-1,text2.length()-1,text1,text2,dp);
        return dp[text1.length()][text2.length()];
    }
    int f(int i , int j , String s1, String s2,int[][] dp){
        if(i < 0 || j < 0)
        return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j] = 1+f(i-1,j-1,s1,s2,dp);
        }
        return dp[i][j] = Math.max(f(i-1,j,s1,s2,dp),f(i,j-1,s1,s2,dp));
    }
}