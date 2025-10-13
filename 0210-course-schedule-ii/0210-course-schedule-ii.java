class Solution {
    public int[] findOrder(int numCourses, int[][] pre) {
        int indegree[] = new int[numCourses];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 0 ; i < numCourses ; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0 ; i < pre.length ; i++){
            list.get(pre[i][1]).add(pre[i][0]);
            indegree[pre[i][0]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0 ; i < indegree.length ; i++){
            if(indegree[i] == 0) que.add(i);
        }
        int i = 0 ;
        int res[] = new int[numCourses];
        while(!que.isEmpty()){
            int node = que.poll();
            res[i++] = node;
            for(int j = 0 ; j < list.get(node).size() ; j++){
                indegree[list.get(node).get(j)]--;
                if(indegree[list.get(node).get(j)] == 0) que.add(list.get(node).get(j));
            }
        }
        if(i != numCourses) return new int[0];
        else return res;
    }
}