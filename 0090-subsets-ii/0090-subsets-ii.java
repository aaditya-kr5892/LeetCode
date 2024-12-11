class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        subset(list,l,nums,0);
        return list;
    }
    void subset(List<List<Integer>> list, List<Integer> l, int arr[], int i){
        list.add(new ArrayList<>(l));
        for(int j = i ; j < arr.length ; j++){
            if(j>i && arr[j] == arr[j-1])
            continue;
            l.add(arr[j]);
            subset(list,l,arr,j+1);
            l.remove(l.size()-1);
        }
    }
}