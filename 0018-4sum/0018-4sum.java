class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(i > 0 && nums[i-1] == nums[i]) continue;
            // sum+=nums[i];
            for(int j = i+1 ; j < nums.length ; j++){
                // sum+=nums[j];
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int l = j+1;
                int r = nums.length-1; 
                while(l < r){
                    long sum = 0;
                    sum+=(long)nums[i];
                    sum+=(long)nums[j];
                    List<Integer> res = new ArrayList<>();
                    
                    if((long)nums[l]+(long)nums[r]+sum == (long)target){
                        res.add(nums[i]);
                        res.add(nums[j]);
                        res.add(nums[l]);
                        res.add(nums[r]);
                        l++;
                        r--;
                        list.add(res);
                        while(l < r && nums[l] == nums[l-1]) l++;
                        while(l < r && nums[r] == nums[r+1]) r--;
                    }
                    else if(nums[l]+nums[r]+sum < target){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
            }
        }
        return list;
    }
}