class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            sum+=nums[i];
        }
        if(sum%2 != 0) return false;
        int dp[][] = new int[nums.length][sum/2+1];
        for(int i = 0 ; i < dp.length ; i++){
            for(int j = 0 ; j < dp[0].length ; j++){
                dp[i][j] = -1;
            }
        }
        return f(nums.length-1,sum/2,dp,nums);
    }
    boolean f(int i , int target, int dp[][], int arr[]){
        if(target == 0) return true;
        if(i == 0) return arr[i] == target;
        if(dp[i][target] != -1) return dp[i][target] == 1;
        boolean not = f(i-1,target,dp,arr);
        boolean take = false;
        if(arr[i] <= target) 
            take = f(i-1,target-arr[i],dp,arr);
        if(take == true || not == true)
            dp[i][target] = 1;
        else
            dp[i][target] = 0;
        return dp[i][target]==1 ;
    }
}