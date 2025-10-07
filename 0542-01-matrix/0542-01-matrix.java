class data{
    int i;
    int j;
    int depth;
    data(int i, int j, int depth){
        this.i = i;
        this.j = j;
        this.depth = depth;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<data> que = new LinkedList<>();
        int v[][] = new int[mat.length][mat[0].length];
        int visited[][] = new int [mat.length][mat[0].length];
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 0){
                    que.add(new data(i, j, 0));
                }
                v[i][j] = Integer.MAX_VALUE;
            }
        }

        while(!que.isEmpty()){
            data d = que.poll();
            if(mat[d.i][d.j] == 0)
            v[d.i][d.j] = 0;
            int drow[] = {0, 1, 0, -1};
            int dcol[] = {1, 0, -1, 0};
            for(int i = 0 ; i < 4 ; i++){
                int nrow = d.i + drow[i];
                int ncol = d.j + dcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < mat.length && ncol < mat[0].length){
                    if(visited[nrow][ncol] == 0 && mat[nrow][ncol] == 1){
                        que.add(new data(nrow, ncol, d.depth+1));
                        v[nrow][ncol] = Math.min(d.depth+1, v[nrow][ncol]);
                        visited[nrow][ncol] = 1;
                    }
                }
            }
        }
        return v;
    }
}