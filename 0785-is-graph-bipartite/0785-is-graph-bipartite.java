class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        for(int i = 0 ; i < graph.length ; i++){
            if(color[i] == -1){
                boolean r = f(graph, color, 0, i);
                if(r == false) return false;
            }
        }
        return true;
    }
    boolean f(int[][] graph, int[] color, int col, int node){
        color[node] = col;
        
        for(int i = 0 ; i < graph[node].length ; i++){
            if(color[graph[node][i]] == -1){
                color[graph[node][i]] = 1-col;
                boolean r = f(graph, color, 1-col, graph[node][i]);
                if(r == false) return false;
            }
            if(color[graph[node][i]] == color[node]){
                return false;
            }
            
        }
        return true;
    }
}