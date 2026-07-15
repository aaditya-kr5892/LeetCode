class Solution {
    public String longestPalindrome(String s) {
        int max = 0;
        String res="";
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = 0 ; j < s.length() ; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0 ; i < s.length() ; i++){
            for(int j = i ; j < s.length() ; j++){
                if(f(i, j, s, dp)){
                    if(max < j-i+1){
                        max = j-i+1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }
        return res;
    }
    boolean f(int i, int j, String s, int[][]dp){
        if(i >= j) return true;
        if(dp[i][j] != -1) return dp[i][j] == 1;
        if(s.charAt(i) != s.charAt(j)) return false;
        dp[i][j] = ((f(i+1, j-1, s, dp))?1:0);
        return dp[i][j] == 1;
    }
}