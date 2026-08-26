class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < isConnected.length ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < isConnected.length ; i++){
            for(int j = 0 ; j < isConnected[i].length ; j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        int visited[] = new int[adj.size()];
        // visited[0] = 1;
        int count = 0;
        for(int i = 0 ; i < adj.size() ; i++){
            if(visited[i] == 0){
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;

    }
    void dfs(int node, List<List<Integer>> adj, int[] visited){
        visited[node] = 1;
        for(int i = 0 ; i < adj.get(node).size() ; i++){
            if(visited[adj.get(node).get(i)] != 1)
            dfs(adj.get(node).get(i), adj, visited);
        }
    }
}
