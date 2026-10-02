class Solution {
    public int maxProduct(int[] nums) {
        // int pro = 1;
        int maxValue = Integer.MIN_VALUE;
        
        for(int i = 0 ; i < nums.length ; i++){
            int pro = 1;
            for(int j = i ; j < nums.length ; j++){
                pro = pro * nums[j];
                maxValue = Math.max(maxValue, pro);
            }
        }
        return maxValue;
    }
}