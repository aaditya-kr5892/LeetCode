class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(n-1 > connections.length)
        return -1;
        int visited[] = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < connections.length ; i++){
            adj.get(connections[i][0]).add(connections[i][1]);
adj.get(connections[i][1]).add(connections[i][0]); 

        }
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 0){
                count++;
                bfs(visited,i,adj);
            }
        }
        return count-1;
    }
    void bfs(int visited[], int node, ArrayList<ArrayList<Integer>> adj){
        Queue<Integer> que = new LinkedList<>();
        que.add(node);
        visited[node] = 1;
        while(!que.isEmpty()){
            int t = que.poll();
            for(int j = 0 ; j < adj.get(t).size() ; j++){
                if(visited[adj.get(t).get(j)] == 0){
                    visited[adj.get(t).get(j)] = 1;
                    que.add(adj.get(t).get(j));
                }
            }
        }
    }
}