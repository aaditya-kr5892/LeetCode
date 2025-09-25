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
        dp.get(0).set(0,triangle.get(0).get(0));
        for(int i = 1 ; i < dp.size() ; i++){
            for(int j = 0 ; j < dp.get(i).size() ; j++){
                int down = Integer.MAX_VALUE;
                int dl = Integer.MAX_VALUE;
                if(i > 0 && j > 0)
                dl = triangle.get(i).get(j) + dp.get(i-1).get(j-1);
                if(i > 0 && j < triangle.get(i).size()-1)
                down = triangle.get(i).get(j) + dp.get(i-1).get(j);
                dp.get(i).set(j,Math.min(down,dl));
            }
        }
        for(int i = 0 ; i < triangle.get(triangle.size()-1).size() ; i++){
            min = Math.min(min,dp.get(triangle.size()-1).get(i));
        }
        return min;
    }
    
}