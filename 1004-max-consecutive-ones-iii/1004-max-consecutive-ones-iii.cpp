class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int l = 0, r = 0;
        int maxLen = 0;
        int c0 = 0;
        while(l <= r && r < nums.size()){
            if(nums[r] == 0){
                c0++;
            }
            while(c0 > k){
                if(nums[l] == 0) c0--;
                l++;
            }
            maxLen = max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
};