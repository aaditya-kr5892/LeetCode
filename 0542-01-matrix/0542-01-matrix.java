class custom{
    int i;
    int j;
    int level;

    custom(int i,int j,int level){
        this.i = i;
        this.j = j;
        this.level = level;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int v[][] = new int[n][m];
        Queue<custom> que = new LinkedList<>();
        int visited[][] = new int[mat.length][mat[0].length];
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                visited[i][j] = mat[i][j];
                if(mat[i][j] == 0){
                    v[i][j] = 1;
                    que.add(new custom(i,j,0));
                }
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        while(!que.isEmpty()){
            custom t = que.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nrow = t.i + drow[i];
                int ncol = t.j + dcol[i];
                if(nrow < n && ncol < m && ncol >= 0 && nrow >= 0 && visited[nrow][ncol] == 1 && v[nrow][ncol] == 0){
                    visited[nrow][ncol] = t.level+1;
                    que.add(new custom(nrow,ncol,visited[nrow][ncol]));
                    v[nrow][ncol] = 1;
                }
            }
        }
        return visited;
    }
}