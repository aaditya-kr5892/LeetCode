class Solution {
    public void solve(char[][] board) {
        int visited[][] = new int[board.length][board[0].length];
        for(int i = 0 ; i < board.length ; i++){
            if(visited[i][board[0].length -1] != 1 && board[i][board[0].length -1] == 'O'){
                visited[i][board[0].length-1] = 1;
                dfs(i,board[0].length-1,board,visited);
            }
            if(visited[i][0] != 1 && board[i][0] == 'O'){
                visited[i][0] = 1;
                dfs(i,0,board,visited);
            }
        }
        for(int j = 0 ; j < board[0].length ; j++){
            if(visited[0][j] != 1 && board[0][j] == 'O'){
                visited[0][j] = 1;
                dfs(0,j,board,visited);
            }
            if(visited[board.length-1][j] != 1 && board[board.length-1][j] == 'O'){
                visited[board.length-1][j] = 1;
                dfs(board.length-1,j,board,visited);

            }
        }
        for(int i = 0 ; i < board.length ; i++){
            for(int j = 0 ; j < board[0].length ; j++){
                if(visited[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
    void dfs(int i, int j,char [][]board,int [][]visited){
        int drow[] = {-1,0,1,0};
        int dcol[] = {0,1,0,-1};
        for(int i1 = 0 ; i1 < 4 ; i1++){
            int nrow = i + drow[i1];
            int ncol = j + dcol[i1];
            if(nrow <= board.length-1 && nrow >= 0 && ncol <= board[0].length-1 && ncol >= 0 && visited[nrow][ncol] != 1 && board[nrow][ncol] == 'O'){
                visited[nrow][ncol] = 1;
                dfs(nrow,ncol,board,visited);
            }
        }
    }
}