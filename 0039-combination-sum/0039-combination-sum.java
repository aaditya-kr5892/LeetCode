class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Solution obj = new Solution();
        obj.combine(candidates,list,l,0,target);
        return list;
    }
    void combine(int arr[],List<List<Integer>> list, List<Integer> l,int i,int target){
        if(i == arr.length){
            if(target == 0){
                list.add(new ArrayList<>(l));
            }
            return;
        }
        if(arr[i] <= target){
            l.add(arr[i]);
            combine(arr,list,l,i,target-arr[i]);
            l.remove(l.size()-1);
        }
        combine(arr,list,l,i+1,target);
    }
}