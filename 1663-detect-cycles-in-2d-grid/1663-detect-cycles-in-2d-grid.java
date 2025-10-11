class data{
    int i;
    int j;
    int pi;
    int pj;
    data(int i, int j, int pi, int pj){
        this.i = i;
        this.j = j;
        this.pi = pi;
        this.pj = pj;
    }
}

class Solution {
    public boolean containsCycle(char[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j= 0 ; j < grid[0].length ; j++){
                if(visited[i][j] == 0){
                    if(bfs(i, j, visited, grid)) return true;
                }
            }
        }
        return false;
    }
    boolean bfs(int i, int j, int [][]visited, char [][]grid){
        Queue<data> que = new LinkedList<>();
        que.add(new data(i, j, -1, -1));
        int drow[] = {0, 1, 0, -1};
        int dcol[] = {1, 0, -1, 0};    
        while(!que.isEmpty()){
            data d = que.poll();
            visited[d.i][d.j] = 1;
            for(int i1 = 0 ; i1 < 4 ; i1++){
                int nrow = drow[i1] + d.i;
                int ncol = dcol[i1] + d.j;
                if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length){
                    if(visited[nrow][ncol] == 0 && grid[nrow][ncol] == grid[d.i][d.j]){
                        visited[nrow][ncol] = 1;
                        que.add(new data(nrow, ncol, d.i, d.j));
                    }
                    else if(grid[nrow][ncol] == grid[d.i][d.j] && (nrow != d.pi || ncol != d.pj)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}