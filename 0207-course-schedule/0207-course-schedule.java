class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int visited[] = new int[numCourses];
        int path[] = new int[numCourses];
        
        for(int i = 0 ; i < numCourses ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length ; i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] == 0){
                if(dfs(list,visited,path,i))
                return false;
            }
        }
        return true;
    }
    boolean dfs(ArrayList<ArrayList<Integer>> adj,int visited[],int path[],int node){
        if(visited[node] == 0){
            visited[node] = 1;
            path[node] = 1;
            for(int i = 0 ; i < adj.get(node).size() ; i++){
                if(dfs(adj,visited,path,adj.get(node).get(i)))
                return true;
            }
            path[node] = 0;
        }
        else{
            if(path[node] == 1){
                return true;
            }
            
        }
        return false;
    }
}