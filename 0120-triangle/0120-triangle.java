class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>> dp = new ArrayList<>();
        for(int i = 0 ; i < triangle.size() ; i++){
            dp.add(new ArrayList<>());
        }
        for(int i = 0 ; i < triangle.size() ; i++){
            for(int j = 0 ; j < triangle.get(i).size(); j++){
                dp.get(i).add(-1);
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0 ; i < triangle.get(triangle.size()-1).size() ; i++){
            min = Math.min(min,f(triangle.size()-1, i, triangle, dp));
        }
        return min;
    }
    int f(int i, int j, List<List<Integer>> list, List<List<Integer>> dp){
        if(i == 0 && j == 0 ){
            return list.get(0).get(0);
        }
        if(dp.get(i).get(j) != -1) return dp.get(i).get(j);
        int down = Integer.MAX_VALUE , dl = Integer.MAX_VALUE;
        if(i > 0 && j > 0)
        dl = list.get(i).get(j) + f(i-1,j-1,list,dp);
        if(i > 0 && j < list.get(i).size()-1)
        down = list.get(i).get(j) + f(i-1,j,list,dp);
        dp.get(i).set(j,Math.min(down,dl));
        return dp.get(i).get(j);
    }
}