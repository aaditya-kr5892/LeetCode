class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int st = 0;
        int max_len = 0;
        unordered_map<char, int> m ;
        for(int i = 0 ; i < s.size() ; i++){
            if(m.find(s[i]) == m.end()){
                m[s[i]]++;
            }
            else{
                int j = st;
                for( ; j < i ; j++){
                    // st = j;
                    m[s[j]]--;
                    if(m[s[j]] == 0){
                        m.erase(s[j]);
                    }
                    if(s[j] == s[i]){
                        j++;
                        break;
                    }
                }
                m[s[i]]++;
                st = j;
            }
            max_len = max(max_len, i-st+1);
        }
        return max_len;
    }
};