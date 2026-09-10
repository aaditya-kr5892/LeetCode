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
        queue<pair<int, int>> que;
        que.push({entrance[0], entrance[1]});
        while(!que.empty()){
            int s = que.size();
           
            for(int k = 0 ; k < s ; k++){
                pair<int, int> p = que.front();
                que.pop();
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
                            // visited[nrow][ncol] = 1;
                            min_moves = min(min_moves, curr+1);
                            continue;
                        }
                        if(visited[nrow][ncol] == 0){
                            visited[nrow][ncol] = 1;
                            que.push({nrow, ncol});
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