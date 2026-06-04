class Solution {
    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        for(int s:stones){
            sum+=s;
        }
        // int [][] dp = new int[stones.length][sum+1];
        // for(int i = 0 ; i < dp.length ; i++){
        //     for(int j = 0 ; j < dp[0].length ; j++){
        //         dp[i][j] = -1;
        //     }
        // }
        int prev[] = new int[sum+1];
        for(int i = 0 ; i <= sum ; i++){
            if(stones[0] <= i){
                prev[i] = stones[0];
            }
            else{
                prev[i] = 0;
            }
        }

        for(int i = 1 ; i < stones.length ; i++){
            int[] curr = new int[sum+1];
            for(int j = 0 ; j < sum+1 ; j++){
                int n = prev[j];
                int t = 0;
                if(stones[i] <= j){
                    t = stones[i]+prev[j-stones[i]];
                }

                curr[j] = Math.max(n, t);
            }
            prev = curr;
        }
        // int max = f(stones, stones.length-1, sum/2, dp);
        int max = prev[sum/2];
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