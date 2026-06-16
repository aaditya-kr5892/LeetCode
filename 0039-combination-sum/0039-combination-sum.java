class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        f(nums, target, 0, list, l);
        return list;
    }

    void f(int[] nums, int target, int i, List<List<Integer>> list, List<Integer> l){
        if(target == 0){
            list.add(new ArrayList(l));
            return;
        }
        if(i == nums.length){

            return;
        }

        if(nums[i] <= target){
            l.add(nums[i]);
            f(nums, target-nums[i], i, list, l);
            l.remove(l.size()-1);
        }
        f(nums, target, i+1, list, l);

    }
}