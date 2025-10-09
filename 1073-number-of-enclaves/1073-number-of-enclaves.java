class data{
    int i;
    int j;
    data(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int visited[][] = new int[grid.length][grid[0].length];
        Queue<data> que = new LinkedList<>();

        int count = 0 ;

        for(int i = 0 ; i < grid.length ; i++){
            if(grid[i][0] == 1){
                que.add(new data(i, 0));
            }
            if(grid[i][grid[0].length-1] == 1){
                que.add(new data(i, grid[0].length-1));
            }
        }

        for(int i = 0 ; i < grid[0].length ; i++){
            if(grid[0][i] == 1){
                que.add(new data(0, i));
            }
            if(grid[grid.length-1][i] == 1){
                que.add(new data(grid.length-1, i));
            }
        }

        while(!que.isEmpty()){
            data d = que.poll();
            visited[d.i][d.j] = 1;
            int drow[] = {0, 1, 0, -1};
            int dcol[] = {1, 0, -1, 0};
            for(int i = 0 ; i < 4 ; i++){
                int nrow = d.i + drow[i];
                int ncol = d.j + dcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < grid.length && ncol < grid[0].length){
                    if(grid[nrow][ncol] == 1 && visited[nrow][ncol] == 0){
                        visited[nrow][ncol] = 1;
                        que.add(new data(nrow, ncol));
                    }
                }
            }
        }

        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(visited[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }

        return count;

    }
}