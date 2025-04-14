class custom{
    int cell;
    int row;
    int col;
    custom(int cell , int row, int col){
        this.cell = cell;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1)
        return -1;
        int dist[][] = new int[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[i].length ; j++){
                if(i ==0 && j ==0)
                dist[i][j] = 1;
                else
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<custom> que = new LinkedList<>();
        int drow[] = {-1,0,1,0,1,-1,1,-1};
        int dcol[] = {0,1,0,-1,1,1,-1,-1};
        que.add(new custom(1,0,0));
        while(!que.isEmpty()){
            custom t = que.poll();
            for(int k = 0 ; k < 8 ; k++){
                int nrow = t.row+drow[k];
                int ncol = t.col+dcol[k];
                if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[t.row].length && grid[nrow][ncol] == 0){
                    if(dist[t.row][t.col] + 1 < dist[nrow][ncol]){
                        que.add(new custom(dist[t.row][t.col] + 1,nrow,ncol));
                        dist[nrow][ncol] = dist[t.row][t.col] + 1;
                    }
                }
            }
        }
        return dist[grid.length-1][grid[grid.length-1].length-1] == Integer.MAX_VALUE ? -1: dist[grid.length-1][grid[grid.length-1].length-1];
    }
}