class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return meth(nums,goal) - meth(nums,goal-1);
    }
    int meth(int arr[], int goal){
        if(goal < 0)
        return 0;
        int l = 0 , r = 0 ,count = 0 ,sum = 0,count2 = 0;
        while(r < arr.length){
            sum += arr[r];
            while(sum > goal){
                sum -= arr[l];
                l++;
            }
            if(sum <= goal)
            count += r-l+1;
            r++;
        }
        return count;
    }
}