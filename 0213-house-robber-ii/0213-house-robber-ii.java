class Solution {
    public int rob(int[] nums) {
        //int dp[] = new int[nums.length];
        //dp[0] = nums[0];
        int prev = nums[0] ;
        int prev2= 0;
        for(int i = 1 ; i < nums.length-1 ; i++){
            int pick = nums[i] + prev2 ;
            int not = prev;
            int curi = Math.max(pick,not);
            prev2 = prev ;
            prev = curi;
        }
        int max = prev;
        if(nums.length > 1){
            prev = nums[1];
            prev2 = 0;
            
            for(int i = 2 ; i < nums.length ; i++){
                int pick = nums[i] + prev2 ;
                int not = prev;
                int curi = Math.max(pick,not);
                prev2 = prev ;
                prev = curi;
            }
        }
        return Math.max(max,prev);
    }
}