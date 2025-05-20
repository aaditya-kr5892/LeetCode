class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int arr[] = new int[nums.length];
        for(int i = 0 ; i < queries.length ; i++){
            arr[queries[i][0]] -= 1;
            if(queries[i][1] < nums.length-1)
            arr[queries[i][1]+1] += 1;
        }
        int prefix[] = new int[nums.length];
        int sum = 0 ;
        for(int i = 0 ; i < arr.length ; i++){
            sum+=arr[i];
            prefix[i] = sum;
            if(nums[i] != 0)
            nums[i] += prefix[i];
            if(nums[i] > 0) return false;
        }
        return true;
    }
}