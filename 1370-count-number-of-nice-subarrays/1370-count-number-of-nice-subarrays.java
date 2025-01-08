class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return meth(nums,k) - meth(nums,k-1);
    }
    int meth(int arr[], int k){
        if(k < 0)
        return 0;
        int l = 0 , r= 0 , count = 0,subcount=0;
        while(r < arr.length){
            if(arr[r] % 2 != 0)
            count++;
            while(count > k){
                if(arr[l] % 2 != 0)
                count--;
                l++;
            }
            if(count <= k)
            subcount += r-l+1;
            r++;
        }
        return subcount;
    }
}