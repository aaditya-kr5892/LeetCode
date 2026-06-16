class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        f(list, l, 0, nums);
        return list;
    }
    void f(List<List<Integer>> list, List<Integer> l, int i, int []nums){
        if(i == nums.length){
            list.add(new ArrayList<>(l));

            return;
        }

        l.add(nums[i]);
        f(list, l, i+1, nums);
        l.remove(l.size()-1);
        f(list, l, i+1, nums);
    }
}