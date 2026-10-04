class Solution {
public:
    bool isValid(int i, int j, vector<vector<int>>& grid){
        if(i >= 0 && j >= 0 && i < grid.size() && j < grid[0].size()) return true;
        return false;
    }
    int orangesRotting(vector<vector<int>>& grid) {
        int m = grid.size();
        int n = grid[0].size();
        vector<vector<int>> visited(m, vector<int>(n, -2));
        queue<pair<pair<int, int>, int>> que;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != 0) visited[i][j] = -1;
                if(grid[i][j] == 2){
                    que.push({{i, j}, 0});
                    visited[i][j] = 0;
                }
            }
        }
        vector<int> drow = {0, 1, 0, -1};
        vector<int> dcol = {1, 0, -1, 0};
        while(!que.empty()){
            pair<int, int> p = que.front().first;
            int time = que.front().second;
            que.pop();
            for(int i = 0 ; i < 4 ; i++){
                int nrow = p.first+drow[i];
                int ncol = p.second+dcol[i];
                if(isValid(nrow, ncol, grid)){
                    if(visited[nrow][ncol] == -1){
                        visited[nrow][ncol] = time+1;
                        que.push({{nrow, ncol}, time+1});
                    }
                    else if(visited[nrow][ncol] > time+1){
                        visited[nrow][ncol] = time+1;
                        que.push({{nrow, ncol}, time+1});
                    }
                }
            }
        }
        int maxTime = 0;
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(visited[i][j] == -1){
                    return -1;
                }
                maxTime = max(maxTime, visited[i][j]);
            }
        }

        return maxTime;
    }
    
};