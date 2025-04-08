class Solution {
    public int minimumOperations(int[] nums) {
        //Map<Integer,Integer> map = new HashMap<>();
        int maxI = 0 ; 
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }
        if(set.size()==nums.length)
            return 0;
        for(int i : set){
            int count = 0 ;
            for(int j = nums.length-1 ; j >=0 ; j--){
                if(i==nums[j]){
                    count++;
                    if(count == 2)
                        maxI = Math.max(maxI,j);
                }
            }
        }
        return maxI/3+1;
    }
}