class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int s:stones){
            sum+=s;
        }
        int [][] dp = new int[stones.length][sum+1];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        int max = f(stones, stones.length-1, sum/2, dp);
        return (sum-2*max);
    }

    int f(int []nums, int ind, int target, int[][]dp){
        if(ind == 0){
            if(nums[ind] <= target){
                return nums[ind];
            }
            return 0;
        }
        if(dp[ind][target] != -1) return dp[ind][target];

        int n = f(nums, ind-1, target, dp);
        int t = 0;
        if(nums[ind] <= target){
            t = nums[ind]+f(nums, ind-1, target-nums[ind], dp);
        }

        return dp[ind][target] = Math.max(n, t);
    }
}