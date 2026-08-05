class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int visited[][] = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(visited[i][j] != 1 && grid[i][j] == '1'){
                    count++;
                    dfs(i, j, grid, visited);
                }
            }
        }
        return count;
    }
    void dfs(int i, int j, char[][] grid, int[][] visited){
        visited[i][j] = 1;
        int drow[] = {0, 1, 0, -1};
        int dcol[] = {1, 0, -1, 0};
        for(int k = 0 ; k < drow.length ; k++){
            int nrow = i+drow[k];
            int ncol = j+dcol[k];
            if(isValid(nrow, ncol, grid)){
                if(visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                    dfs(nrow, ncol, grid, visited);
                }
            }
        }
    }
    boolean isValid(int nrow, int ncol, char[][] grid){
        if(nrow >= 0 && nrow < grid.length && ncol >= 0 && ncol < grid[0].length){
            return true;
        }
        return false;
    }
}