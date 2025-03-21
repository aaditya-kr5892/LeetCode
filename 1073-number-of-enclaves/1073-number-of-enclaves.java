class Solution {
    public int numEnclaves(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            if(visited[i][0] == 0 && grid[i][0] == 1){
                visited[i][0] = 1;
                dfs(i,0,visited,grid);
            }
            if(visited[i][grid[0].length-1] == 0 && grid[i][grid[0].length-1] == 1){
                visited[i][grid[0].length-1] = 1;
                dfs(i,grid[0].length-1 , visited,grid);
            }
        }
        for(int j = 0 ; j < grid[0].length ; j++){
            if(visited[0][j] == 0 && grid[0][j] == 1){
                visited[0][j] = 1;
                dfs(0,j,visited,grid);
            }
            if(visited[grid.length-1][j] == 0 && grid[grid.length-1][j] == 1){
                visited[grid.length-1][j] = 1;
                dfs(grid.length-1,j,visited,grid);
            }
        }
        int count = 0 ;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(visited[i][j] != 1 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(int i , int j , int[][]visited,int[][] board){
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        for(int i1 = 0 ; i1 < 4 ; i1++){
            int nrow = i + drow[i1];
            int ncol = j + dcol[i1];
            if(nrow >= 0 && ncol <= board[0].length-1 && ncol >= 0 && nrow <= board.length-1 && visited[nrow][ncol] != 1 && board[nrow][ncol] == 1){
                visited[nrow][ncol] = 1;
                dfs(nrow,ncol,visited,board);
            }
        }
    }
}