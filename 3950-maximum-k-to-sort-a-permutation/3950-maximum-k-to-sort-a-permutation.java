class Solution {
    public int sortPermutation(int[] nums) {
        int x = Integer.MAX_VALUE;
        for(int i = 0 ; i < nums.length ; i++){
            if(i != nums[i]){
                x = nums[i] & x;
            }
        }
        return (x==Integer.MAX_VALUE?0:x);
    }
}