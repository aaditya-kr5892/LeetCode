class Solution {
    public int minimumArea(int[][] grid) {
        int minl = Integer.MAX_VALUE;
        int minu = Integer.MAX_VALUE;
        int maxu = Integer.MIN_VALUE;
        int maxr = Integer.MIN_VALUE;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    minl= Math.min(minl, j);
                    maxr = Math.max(maxr, j);
                    minu= Math.min(minu, i);
                    maxu= Math.max(maxu, i);
                }
            }
        }
        int len = maxr-minl+1;
        int br = maxu-minu+1;
    
        return len*br;
    }
}