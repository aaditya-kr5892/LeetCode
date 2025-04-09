class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]== k){
                count++;
            }
        }
        if(count == nums.length){
            return 0;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > k){
                set.add(nums[i]);
            }
            if(nums[i] <k){
                return -1;
            }
        }
        if(set.isEmpty()){
            return -1;
        }
        return set.size();
    }
}