class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        int n =(int)Math.pow(2,nums.length);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < nums.length ; j++){
                if((i&(1<<j)) != 0)
                l.add(nums[j]);
            }
            list.add(new ArrayList<>(l));
            l.clear();
        }
        return list;
    }
}