class Solution {
    public int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0 ;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]>low)
            low = nums[i];
            high += nums[i];
        }
        while(low<=high){
            int mid = (low+high)/2;
            int subarray = f(nums,mid);
            if(subarray<=k)
            high = mid-1;
            else
            low = mid+1;
        }
        return low;
    }
    static int f(int arr[] , int maxsum){
        int currsum = 0 ; 
        int subarray = 1 ; 
        for(int i = 0 ; i < arr.length ; i++){
            if(currsum+arr[i] <= maxsum){
                currsum+=arr[i];
            }
            else{
                subarray++;
                currsum = arr[i];
            }
        }
        return subarray;
    }
}