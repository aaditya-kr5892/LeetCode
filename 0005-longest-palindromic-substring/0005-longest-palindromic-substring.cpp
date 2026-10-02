class Solution {
public:
    string longestPalindrome(string s) {
        vector<vector<int>> dp(s.size(), vector<int>(s.size(), -1));
        int maxLen = 0;
        string res;
        for(int i = 0 ; i < s.size() ; i++){
            for(int j = i ; j < s.size() ; j++){
                if(isPalindrome(i, j, s, dp)){
                    if(maxLen < j-i+1){
                        maxLen = j-i+1;
                        res = s.substr(i, maxLen);
                    }
                }
            }
        }
        return res;
    }
    bool isPalindrome(int i, int j, string& s, vector<vector<int>>& dp){
        if(i > j){
            return true;
        }
        if(j < 0){
            return true;
        }
        if(dp[i][j] != -1) return dp[i][j] == 1;
        if(s[i] != s[j]) return false;

        bool r = isPalindrome(i+1, j-1, s, dp);
        dp[i][j] = (r == true)?1:0;
        if(r == false) return false;
        return true;
    }
};