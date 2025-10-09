class data{
    int i;
    int j;
    data(int i, int j){
        this.i = i;
        this.j = j;
        
    }
}
class Solution {
    public void solve(char[][] board) {
        int visited[][] = new int[board.length][board[0].length];
        Queue<data> que = new LinkedList<>();
        for(int i = 0 ; i < board.length ; i++){
            if(board[i][0] == 'O'){
                que.add(new data(i, 0));
            }
            if(board[i][board[0].length-1] == 'O'){
                que.add(new data(i, board[0].length-1));
            }
        }

        for(int i = 0 ; i < board[0].length ; i++){
            if(board[0][i] =='O'){
                que.add(new data(0, i));
            }
            if(board[board.length-1][i] == 'O'){
                que.add(new data(board.length-1, i));
            }
        }

        while(!que.isEmpty()){
            data d = que.poll();
            visited[d.i][d.j] = 1;
            int[] drow = {0, 1, 0, -1};
            int[] dcol = {1, 0, -1, 0};
            for(int i = 0 ; i < 4 ; i++){
                int nrow = drow[i] + d.i;
                int ncol = dcol[i] + d.j;
                if(nrow >= 0 && ncol >= 0 && nrow < board.length && ncol < board[0].length){
                    if(board[nrow][ncol] == 'O' && visited[nrow][ncol] == 0){
                        // board[nrow][ncol] = 'X';
                        visited[nrow][ncol] = 1;
                        que.add(new data(nrow, ncol));
                    }
                }
            }
        }
        for(int i = 0 ; i < visited.length ; i++){
            for(int j = 0 ; j < visited[0].length ; j++){
                if(visited[i][j] == 0){
                    board[i][j] = 'X';
                }
            }
        }
        // return board;
    }
}