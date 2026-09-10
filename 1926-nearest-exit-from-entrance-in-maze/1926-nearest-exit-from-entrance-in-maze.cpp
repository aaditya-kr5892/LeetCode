class Solution {
public:
    int nearestExit(vector<vector<char>>& maze, vector<int>& entrance) {
        int n = maze.size();
        int m = maze[0].size();
        vector<int> drow = {-1, 0, 1, 0};
        vector<int> dcol = {0, 1, 0, -1};
        vector<vector<int>> visited(n, vector<int>(m, 0));
        int min_moves = INT_MAX;
        int curr = 0;
        queue<pair<pair<int, int>, int>> que;
        que.push({{entrance[0], entrance[1]}, 0});
        visited[entrance[0]][entrance[1]] = 1;
        while(!que.empty()){
            int s = que.size();
            pair<pair<int, int>, int> p1 = que.front();
            pair<int, int> p = p1.first;
            que.pop();
            for(int k = 0 ; k < s ; k++){
                for(int i = 0 ; i < 4 ; i++){
                    int nrow = p.first+drow[i];
                    int ncol = p.second+dcol[i];
                    if(isValid(nrow, ncol, maze)){
                        
                        if(maze[nrow][ncol] == '+'){
                            continue;
                        }
                        if(nrow == 0 || ncol == 0 || nrow == maze.size()-1 || ncol == maze[0].size()-1){
                            if(nrow == entrance[0] && ncol == entrance[1]){
                                continue;
                            }
                            visited[nrow][ncol] = 1;
                            min_moves = min(min_moves, p1.second+1);
                            continue;
                        }
                        if(visited[nrow][ncol] == 0){
                            visited[nrow][ncol] = 1;
                            que.push({{nrow, ncol}, p1.second+1});
                        }
                    }
                }
            }
            curr++;
        }
        return (min_moves == INT_MAX)?-1:min_moves;
    }
    bool isValid(int nrow, int ncol, vector<vector<char>>& v){
        if(nrow >= 0 && ncol >= 0 && nrow < v.size() && ncol < v[0].size()){
            return true;
        }
        return false;
    }
};