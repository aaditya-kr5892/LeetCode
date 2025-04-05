class Solution {
    public int subsetXORSum(int[] nums) {
        int arr[] = new int[1];
        int sum[] = new int[1];
        f(nums,arr,0,sum);
        return sum[0];
    }
    void f(int [] nums,int []arr,int ind,int sum[]){
        if(ind == nums.length){
            sum[0] +=arr[0];
            return;
        }
        //return;
        arr[0] = nums[ind] ^ arr[0];
        f(nums,arr,ind+1,sum);
        arr[0] = nums[ind] ^ arr[0];
        f(nums,arr,ind+1,sum);
    }
}