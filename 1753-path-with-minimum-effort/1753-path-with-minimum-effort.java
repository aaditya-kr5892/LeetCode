class custom implements Comparable<custom> {
    int diff;
    int row;
    int col;

    custom(int diff, int row, int col) {
        this.diff = diff;
        this.row = row;
        this.col = col;
    }

    @Override
    public int compareTo(custom other) {
        return this.diff - other.diff; 
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int dist[][] = new int[heights.length][heights[0].length];
        for(int i = 0 ; i < heights.length ; i++){
            for(int j = 0 ; j < heights[0].length ; j++){
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        PriorityQueue<custom> que = new PriorityQueue<>();
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        que.add(new custom(0,0,0));
        while(!que.isEmpty()){
            custom t = que.poll();
            for(int i = 0 ; i < 4 ; i++){
                int nrow = t.row+drow[i];
                int ncol = t.col+dcol[i];
                if(nrow >= 0 && ncol >= 0 && nrow < heights.length && ncol < heights[t.row].length){
                    int currentEffort = Math.max(t.diff, Math.abs(heights[nrow][ncol] - heights[t.row][t.col]));
                    if(currentEffort < dist[nrow][ncol]){
                        dist[nrow][ncol] = currentEffort;
                        que.add(new custom(currentEffort, nrow, ncol));
                    }
                }
            }
        }
        return dist[dist.length-1][dist[dist.length-1].length-1];
    }
}