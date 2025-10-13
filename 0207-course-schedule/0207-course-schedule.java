class Solution {
    public boolean canFinish(int numCourses, int[][] pre) {
        int indegree[] = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            list.add(new ArrayList<>());
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ; i< pre.length ; i++){
            indegree[pre[i][0]]++;
            list.get(pre[i][1]).add(pre[i][0]);
        }
        for(int i = 0; i < indegree.length ; i++){
            if(indegree[i] ==0){
                que.add(i);
            }
        }
        if(que.size() == 0){
            return false;
        }
        int count = 0;
        while(!que.isEmpty()){
            int node = que.poll() ;
            count++;
            for(int i = 0 ; i < list.get(node).size() ; i++){
                indegree[list.get(node).get(i)]--;
                if(indegree[list.get(node).get(i)] == 0){
                    que.add(list.get(node).get(i));
                }
            }
        }
        if(count != numCourses) return false;
        else return true;
    }
}