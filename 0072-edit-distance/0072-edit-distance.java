class Solution {
    public int minDistance(String word1, String word2) {
        int [][] dp = new int[word1.length()][word2.length()];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(word1, word2, 0, 0, dp);
    }
    int f(String w1, String w2, int i, int j, int[][] dp){
        if (i == w1.length()) return w2.length() - j;
        if (j == w2.length()) return w1.length() - i;
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(w1.charAt(i) == w2.charAt(j)){
            return dp[i][j] = f(w1, w2, i+1, j+1, dp);
        }
        int in = f(w1, w2, i, j+1, dp);
        int re = f(w1, w2, i+1, j+1, dp);
        int de = f(w1, w2, i+1,j, dp);
        return dp[i][j] = 1+Math.min(in, Math.min(re, de));
    }
}