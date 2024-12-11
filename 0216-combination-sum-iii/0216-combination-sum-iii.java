class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        int arr[] = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        Solution obj = new Solution();
        obj.combine(list,l,k,n,0,arr);
        return list;
    }
    void combine(List<List<Integer>> list, List<Integer> l, int k , int n, int i, int arr[]){
        if(l.size() == k){
            if(n == 0)
            list.add(new ArrayList<>(l));
            return;
        }
        if(l.size() < k && i < arr.length){
            if(arr[i] <= n){
                l.add(arr[i]);
                combine(list,l,k,n-arr[i],i+1,arr);
                l.remove(l.size()-1);
            }
            combine(list,l,k,n,i+1,arr);
        }
    }
}