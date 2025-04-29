class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0 ;
        int count = 0;
        long product = 1;

        for(int j = 0 ; j < nums.length ; j++){
            product *= nums[j];
            while(i <= j && product >= k){
                product /= nums[i];
                i++;
            }
            count+=j-i+1;
        }
        return count;
    }
}