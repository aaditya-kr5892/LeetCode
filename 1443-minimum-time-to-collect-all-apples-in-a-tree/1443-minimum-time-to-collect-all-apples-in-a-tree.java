class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < edges.length ; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        return dfs(0, -1, adj, hasApple);
    }
    int dfs(int curr, int parent, List<List<Integer>> adj, List<Boolean> hasApple){
        int time = 0;
        for(int i = 0 ; i < adj.get(curr).size() ; i++){
            if(adj.get(curr).get(i) == parent){
                continue;
            }
            int t = dfs(adj.get(curr).get(i), curr, adj, hasApple);
            if(t != 0 || hasApple.get(adj.get(curr).get(i)) == true){
                time+=(t+2);
            }
        }
        return time;
    }
}