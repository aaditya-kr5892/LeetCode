class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0 , r = 0 , count0 = 0 , max = 0;
        while(l < nums.length && r < nums.length){
            if(nums[r] == 0){
                count0++;
            }
            if(count0 <= k){
                max = (max > r-l+1)?max:(r-l+1);
            }
            if(count0 > k){
                if(nums[l] == 0)
                count0--;
                l = l+1;
            }
            r++;
        }
        return max;
    }
}