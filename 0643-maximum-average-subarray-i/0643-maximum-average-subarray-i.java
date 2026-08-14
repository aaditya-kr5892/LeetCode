class Solution {
    public double findMaxAverage(int[] nums, int k) {
        // int l = 0,r = 1;
        long sum = 0;
        long max = Long.MIN_VALUE;
        for(int i = 0 ; i < k ; i++){
            sum+=((long)nums[i]);
        }
        int l = 0, r = k;
        while(l <= r && r < nums.length){
            // sum+=nums[r];
            max = Math.max(max, sum);

            sum -= nums[l];
            
            sum += nums[r];
            l++;
            r++;
            
        }
        max = Math.max(max, sum);
        return (double)max/(k*1.0d);
    }
}