class Solution {
public:
    int rob(vector<int>& nums) {
        vector<int> dp(nums.size(), -1);
        return f(nums, 0, dp);
    }
    int f(vector<int>& nums, int ind, vector<int>& dp){
        if(ind >= nums.size()){
            return 0;
        }

        if(dp[ind] != -1) return dp[ind];

        int take = nums[ind] + f(nums, ind+2, dp);
        int not_take = f(nums, ind+1, dp);
        return dp[ind] = max(not_take, take);
    }
};