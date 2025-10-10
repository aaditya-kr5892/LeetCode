class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] visited = new int[n];
        int[] depth = new int[n];  

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                if (!dfs(i, -1, 0, visited, depth, graph)) return false;
            }
        }
        return true;
    }

    boolean dfs(int node, int parent, int level, int[] visited, int[] depth, int[][] graph) {
        visited[node] = 1;
        depth[node] = level;

        for (int neighbor : graph[node]) {
            if (visited[neighbor] == 0) {
                if (!dfs(neighbor, node, level + 1, visited, depth, graph)) return false;
            } 
            else if (neighbor != parent) {
                int cycleLength = Math.abs(depth[node] - depth[neighbor]) + 1;
                if (cycleLength % 2 == 1) return false; 
            }
        }
        return true;
    }
}
