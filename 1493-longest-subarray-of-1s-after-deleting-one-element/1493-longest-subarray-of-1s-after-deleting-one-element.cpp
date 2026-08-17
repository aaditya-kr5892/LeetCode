class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int l = 0, r = 0;
        int maxLen = 0, c0 = 0;
        while(l <= r && r < nums.size()){
            if(nums[r] == 0){
                c0++;
            }
            while(l < nums.size() && c0 > 1){
                if(nums[l] == 0) c0--;
                l++;
            }
            maxLen = max(maxLen, r-l);
            r++;
        }
        if(c0 == 0) return nums.size()-1;
        // maxLen = max(maxLen, r-l);
        return maxLen;
    }
};