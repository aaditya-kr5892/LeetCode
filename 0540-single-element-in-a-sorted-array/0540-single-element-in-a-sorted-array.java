class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = (low+high)/2;
            if(mid > 0 && nums[mid] == nums[mid-1]){
                if(mid % 2 == 1){
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            else if(mid < nums.length-1 && nums[mid] == nums[mid+1]){
                if(mid%2 == 1){
                    high = mid-1;
                }
                else{
                    low = mid+1;
                }
            }
            else{
                return nums[mid];
            }
        }
        return nums[low];
    }
}