class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            int diff = k-nums[i];
            if(diff < 0) continue;
            
            if(map.containsKey(diff) && map.containsKey(nums[i])){
                if(diff == nums[i]){
                    if(map.get(diff) < 2){
                        continue;
                    }
                }
                map.put(diff, map.get(diff)-1);

                if(map.get(diff) == 0){
                    map.remove(diff);
                }

                map.put(nums[i], map.get(nums[i])-1);
                
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                count++;
            }
        }
        return count;
    }
}