class custom{
    int i ;
    int j ;
    custom(int i , int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length ; 
        int m = image[0].length ;
        int visited[][] = new int[image.length][image[0].length];
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < m ; j++){
                visited[i][j] = image[i][j];
            }
        }
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        int ini = image[sr][sc];
        visited[sr][sc] = color;
        int v[][] = new int[image.length][image[0].length];
        Queue<custom> que = new LinkedList<>();
        que.add(new custom(sr,sc));
        while(!que.isEmpty()){
            custom t = que.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nrow = t.i+drow[i];
                int ncol = t.j+dcol[i];
                if(nrow < n && nrow >= 0 && ncol >= 0 && ncol < m && visited[nrow][ncol] == ini && v[nrow][ncol] == 0){
                    ini = visited[nrow][ncol];
                    visited[nrow][ncol] = color;
                    que.add(new custom(nrow,ncol));
                    v[nrow][ncol] = 1;
                    
                }
            }
        }
        return visited;
    }
}