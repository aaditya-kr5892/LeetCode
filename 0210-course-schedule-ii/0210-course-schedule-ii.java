class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int topo[] = new int[numCourses];
        int indegree[] = new int[numCourses];
        
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
        if(k == indegree.length)
        return topo;
        else
        return new int[0];
    }
}