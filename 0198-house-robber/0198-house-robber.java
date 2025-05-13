class Solution {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length];
        Arrays.fill(dp,-1);
        return f(nums.length-1,nums,dp);
    }
    int f(int ind,int [] nums,int [] dp){
        if(ind == 0) return nums[ind];
        if(ind < 0) return 0;
        if(dp[ind] != -1)
        return dp[ind];
        int pick = nums[ind] + f(ind-2,nums,dp);
        int not = f(ind-1,nums,dp);
        return dp[ind] = Math.max(pick,not);
    }
}