class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int topo[] = new int[numCourses];
        int indegree[] = new int[numCourses];
        int visited[] = new int[numCourses];
        int path[] = new int[numCourses];
        for(int i = 0 ; i < numCourses ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < prerequisites.length ; i++){
            list.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }
        if(que.isEmpty())
        return new int[0];
        for(int i = 0 ; i < numCourses ; i++){
            if(visited[i] == 0){
                if(dfs(list,visited,path,i))
                return new int[0];
            }
        }
        int k = 0 ;
        while(!que.isEmpty()){
            int t = que.poll();
            topo[k++] = t;
            for(int i = 0 ; i < list.get(t).size() ; i++){
                indegree[list.get(t).get(i)]--;
                if(indegree[list.get(t).get(i)] == 0){
                    que.add(list.get(t).get(i));
                }
            }
        }
        return topo;
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