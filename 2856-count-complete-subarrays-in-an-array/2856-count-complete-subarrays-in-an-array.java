class Solution {
    public int countCompleteSubarrays(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            set.add(nums[i]);
        }

        int res = 0;
        int u = set.size() ;
        int i = 0 ;
        int j = 0;
        while(i < nums.length  && j < nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while(map.size() == u){
                res += nums.length - j;
                //break;
                //i++;
                map.put(nums[i],map.get(nums[i])-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                    //return res;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}