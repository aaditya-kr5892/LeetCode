class data{
    int i;
    int j;
    data(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int numIslands(char[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1' && visited[i][j] == 0){
                    bfs(i, j, visited, grid);
                    count++;
                }
            }
        }
        return count;
    }
    void bfs(int i, int j, int[][] visited, char[][] grid){
        Queue<data> que = new LinkedList<>();
        que.add(new data(i, j));
        while(!que.isEmpty()){
            data d = que.poll();
            visited[d.i][d.j] = 1;
            int drow[] = {0, 1, 0, -1};
            int dcol[] = {1, 0, -1, 0};
            for(int i1 = 0 ; i1 < 4 ; i1++){
                int nrow = drow[i1] +d.i;
                int ncol = dcol[i1] +d.j;
                if(nrow >=0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length){
                    if(visited[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        visited[nrow][ncol] = 1;
                        que.add(new data(nrow, ncol));
                    }
                }
                
            }
        }
    }
}