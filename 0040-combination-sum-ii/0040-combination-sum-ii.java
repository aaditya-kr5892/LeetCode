class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Solution obj = new Solution();
        obj.combine(list,l,candidates,0,target);
        return list;
    }
    void combine(List<List<Integer>> l,List<Integer> list,int arr[],int i,int target){
        if(target == 0){
            l.add(new ArrayList<>(list));
            //return;
        }
        for(int j = i ; j < arr.length ; j++){
            if(j>i && arr[j] == arr[j-1])
            continue;
            if(arr[i] <= target){
                list.add(arr[j]);
                combine(l,list,arr,j+1,target-arr[j]);
                list.remove(list.size()-1);                
            }
        }
    }
}