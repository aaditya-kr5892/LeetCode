class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        f(nums, 0, list);
        return list;
    }

    void f(int[] nums, int i, List<List<Integer>> list){
        if(i == nums.length){
            List<Integer> l = new ArrayList<>();
            for(int n:nums){
                l.add(n);
            }
            list.add(l);
            return;
        }

        for(int ind = i ; ind < nums.length ; ind++){
            swap(nums, ind, i);
            f(nums, i+1, list);
            swap(nums, ind, i);
        }
    }

    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}