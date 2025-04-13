class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> list = new ArrayList<>();
        int visited[] = new int[graph.length];
        int path[] = new int[graph.length];
        for(int i = 0 ; i < graph.length ; i++){
            if(!dfs(graph,i,visited,path))
            list.add(i);
        }
        return list;
    }
    boolean dfs(int graph[][] , int node, int[] visited, int path[]){
        if(visited[node] != 1){
            if(path[node] != 1){
                visited[node] = 1;
                path[node] = 1;
                for(int i = 0 ; i < graph[node].length ; i++){
                    if(dfs(graph,graph[node][i],visited,path))
                    return true;
                }
            }
            path[node] = 0;
        }
        else{
            if(path[node] == 1)
            return true;
        }
        return false;
    }
}