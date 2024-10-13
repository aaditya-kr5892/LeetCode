class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        //int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i =0 ; i < nums.length ; i++){
            max = Math.max(max,nums[i]);
            //min = Math.min(min,nums[i]);
        }
        int low = 1;
        int  high = max;
        while(low<=high){
            int sum = 0 ; 
            int mid = (low+high)/2;
            for(int i = 0 ; i < nums.length ; i++){
                sum += (int)Math.ceil(nums[i]/(double)mid);
            }
            if(sum <= threshold) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}