class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int currSum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            currSum += nums[i];
            if(currSum < 0){
                currSum = 0;
            }
            sum = Math.max(sum, currSum);
        }
        return sum;
    }
}