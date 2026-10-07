class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int indegree[] = new int[numCourses];
        Queue<Integer> que = new LinkedList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < prerequisites.length ; i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0){
                que.add(i);
            }

        }
        while(!que.isEmpty()){
            int t = que.poll() ; 
            for(int i = 0 ; i < adj.get(t).size() ; i++){
                indegree[adj.get(t).get(i)]--;
                if(indegree[adj.get(t).get(i)] == 0){
                    que.add(adj.get(t).get(i));
                }
            }
        }
        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}