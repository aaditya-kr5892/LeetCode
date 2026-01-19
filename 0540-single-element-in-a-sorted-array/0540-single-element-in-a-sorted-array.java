class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0 ;
        int r = nums.length-1;
        while(l <= r){
            int mid = (l+r)/2;
            if(mid % 2 == 0){
                if(mid != 0 && nums[mid-1] == nums[mid]){
                    r = mid-1;
                }
                else if(mid != nums.length-1 && nums[mid+1] == nums[mid]){
                    l = mid+1;
                }
                else return nums[mid];
            }
            else{
                if(mid != 0 && nums[mid-1] == nums[mid]){
                    l = mid+1;
                }
                else if(mid != nums.length-1 && nums[mid+1] == nums[mid]){
                    r = mid-1;
                }
                else return nums[mid];
            }
        }
        return nums[0];
    }
}