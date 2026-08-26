class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int visited[] = new int[rooms.size()];
        // visited[0] = 1;
        int count = 0;
        for(int i = 0 ; i < rooms.size() ; i++){
            if(visited[i] == 0){
                dfs(i, rooms, visited);
                count++;
            }
        }
        if(count > 1) return false;
        return true;

    }
    void dfs(int node, List<List<Integer>> adj, int[] visited){
        visited[node] = 1;
        for(int i = 0 ; i < adj.get(node).size() ; i++){
            if(visited[adj.get(node).get(i)] != 1)
            dfs(adj.get(node).get(i), adj, visited);
        }
    }
}