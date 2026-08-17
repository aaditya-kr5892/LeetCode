class Solution {
public:
    int largestAltitude(vector<int>& gain) {
        int start = 0;
        int maxVal = 0;
        for(int i = 0 ; i < gain.size() ; i++){
            start+=  gain[i];
            maxVal = max(maxVal, start);
        }
        return maxVal;
    }
};