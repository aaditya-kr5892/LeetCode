class custom{
    int node;
    int parent;
    int depth;
    custom(int node,int parent,int depth){
        this.node = node;
        this.parent = parent;
        this.depth = depth;
    }
}
class Solution {
    public boolean isBipartite(int[][] graph) {
        int visited[] = new int[graph.length];
        for(int i = 0 ; i < visited.length ; i++){
            if(visited[i] == 0){
                if(bfs(graph,i,visited))
                return false;
            }
            
        }
        return true;
    }
    boolean bfs(int graph[][] ,int node,int visited[]){
        Queue<custom> que = new LinkedList<>();
        visited[node] = 1;
        int dist[] = new int[visited.length];
        dist[node] = 0;
        que.add(new custom(node,-1,0));
        //int sh = Integer.MAX_VALUE;
        while(!que.isEmpty()){
            custom t = que.poll();
            for(int j = 0 ; j < graph[t.node].length ; j++){
                if(visited[graph[t.node][j]] == 0){
                    visited[graph[t.node][j]] = 1;
                    dist[graph[t.node][j]] = t.depth+1;
                    que.add(new custom(graph[t.node][j],t.node,t.depth+1));
                }
                else if(graph[t.node][j] != t.parent){
                    int cycleLength = dist[t.node] + dist[graph[t.node][j]] + 1;
                    if (cycleLength % 2 != 0) return true;
                }
            }
        }
        return false;
    }
}