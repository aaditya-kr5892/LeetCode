class Solution {
    public boolean isBipartite(int[][] graph) {
        int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        
        for(int i = 0 ; i < graph.length ; i++){
            if(color[i] == -1){
                if(f(graph, i, color) == false) return false;
            }
        }
        return true;
    }

    boolean f(int[][] graph, int n, int[]color){
        // int color[] = new int[graph.length];
        Arrays.fill(color, -1);
        Queue<Integer> que = new LinkedList<>();

        que.add(n);
        color[n] = 0;

        while(!que.isEmpty()){
            int node = que.poll();
            for(int i = 0 ; i < graph[node].length ; i++){
                if(color[graph[node][i]] == -1){
                    color[graph[node][i]] = 1 - color[node];
                    que.add(graph[node][i]);
                }
                else if(color[graph[node][i]] == color[node]){
                    return false;
                }
            }
        }
        return true;
    }
}