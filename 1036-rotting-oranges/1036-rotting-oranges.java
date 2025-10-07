class data{
    int i;
    int j;
    int layer;
    data(int i, int j, int layer){
        this.i = i;
        this.j = j;
        this.layer = layer;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<data> que = new LinkedList<>();
        int count = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] ==2)
                que.add(new data(i, j, 0));
                // if(grid[i][j] == 1){
                //     count++;
                // }
            }
        }
        // if(count == 0) return 0;
        int visited[][] = new int[grid.length][grid[0].length];
        int max = 0;
        while(!que.isEmpty()){
            data d = que.poll();
            visited[d.i][d.j] = 1;
            grid[d.i][d.j] =2;
            int drow[] = {0, 1, 0, -1};
            int dcol[] = {1, 0, -1, 0};
            for(int i1 = 0 ; i1 < 4 ; i1++){
                int nrow = d.i + drow[i1];
                int ncol = d.j + dcol[i1];
                if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length){
                    if(visited[nrow][ncol] == 0 && grid[nrow][ncol] == 1){
                        grid[nrow][ncol] = 2;
                        que.add(new data(nrow, ncol, d.layer+1));
                        max = Math.max(d.layer+1, max);
                    }
                }
            }
        }
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return max;
    }

}