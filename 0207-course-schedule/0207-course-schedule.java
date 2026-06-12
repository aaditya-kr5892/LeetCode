class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        int indegree[] = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < pre.length ; i++){
            indegree[pre[i][0]]++;
        }

        for(int i = 0; i < numCourses ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < pre.length ; i++){
            adj.get(pre[i][1]).add(pre[i][0]);
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ;i < indegree.length ; i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!que.isEmpty()){
            int node = que.poll();
            list.add(node);
            for(int i = 0 ; i < adj.get(node).size() ; i++){
                indegree[adj.get(node).get(i)]--;
                if(indegree[adj.get(node).get(i)] == 0){
                    que.add(adj.get(node).get(i));
                }
            }
        }

        if(list.size() == numCourses) return true;
        return false;
    }
}