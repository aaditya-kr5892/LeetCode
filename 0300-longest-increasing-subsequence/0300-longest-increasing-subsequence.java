class Solution {
    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length+1][nums.length];
        for(int i = 0 ; i < nums.length+1 ; i++){
            for(int j = 0 ; j < nums.length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(nums, 0, -1, dp);
    }
    int f(int[] nums, int curr, int prev, int[][] dp){
        if(curr == nums.length){
            return 0;
        }
        if(dp[prev+1][curr] != -1) return dp[prev+1][curr];
        int ex = f(nums, curr+1, prev, dp);
        int inc = 0;
        if(prev == -1 || nums[curr] > nums[prev]){
            inc = 1+f(nums, curr+1, curr, dp);
        }
        return dp[prev+1][curr] = Math.max(inc, ex);
    }
}