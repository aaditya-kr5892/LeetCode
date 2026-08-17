class Solution {
public:
    bool uniqueOccurrences(vector<int>& arr) {
        vector<int> freq(2001, 0);
        for(int i = 0 ; i < arr.size() ; i++){
            freq[arr[i] + 1000]++;
        }
        unordered_set<int> set;
        for(int i = 0 ; i < freq.size() ; i++){
            if(freq[i] == 0) continue;
            if(set.contains(freq[i])) return false;
            set.insert(freq[i]);
        }
        return true;
    }
};