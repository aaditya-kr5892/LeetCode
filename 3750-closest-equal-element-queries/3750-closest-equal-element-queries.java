class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int[] cir = new int[3*nums.length];
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        for(int j = 0 ; j < 3*nums.length ; j++){
            cir[j] = nums[j%nums.length];
            if(!map.containsKey(nums[j % nums.length])){
                map.put(nums[j%nums.length],new ArrayList<>());
            }
            map.get(nums[j%nums.length]).add(j);
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < queries.length ; i++){
            int q = queries[i]+nums.length ;
            List<Integer> l = map.get(nums[queries[i]]);
            int low = 0;
            int high = l.size()-1;
            while(low <= high){
                int mid = (low + high)/2;
                if(l.get(mid) < q){
                    low = mid +1;
                }
                else if(l.get(mid) > q){
                    high = mid-1;
                }
                else{
                    int dis = Math.min((l.get(mid)-l.get(mid-1)) , l.get(mid+1)-l.get(mid));
                    dis = Math.min(nums.length,dis);
                    if(dis == nums.length){
                        list.add(-1);
                    }
                    else{
                        list.add(dis);
                    }
                    break;
                }
            }
        }
        return list;
    }
}