class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = new int[str1.length()+1][str2.length()+1];
        for(int i = 1 ; i < str1.length()+1 ; i++){
            for(int j = 1 ; j < str2.length()+1 ; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }
                else if(dp[i-1][j] > dp[i][j-1]){
                    dp[i][j] = dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        int i = dp.length-1;
        int j = dp[0].length-1;
        Stack<Character> st = new Stack<>();
        while(i > 0 && j > 0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                st.push(str1.charAt(i-1));
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                st.push(str1.charAt(i-1));
                i--;
            }
            else{
                st.push(str2.charAt(j-1));
                j--;
            }
        }
        while(i > 0){
            st.push(str1.charAt(i-1));
            i--;

        }
        while(j >0){
            st.push(str2.charAt(j-1));
            j--;
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){

            sb.append(st.pop());
        }
        return sb.toString();
    }
}