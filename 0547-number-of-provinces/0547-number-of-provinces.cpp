class Solution {
public:
    int findCircleNum(vector<vector<int>>& isConnected) {
        int n = isConnected.size();
        vector<vector<int>> adj(n);
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(isConnected[i][j] == 1){
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }
        queue<int> que;
        // que.push(0);
        vector<int> visited(n, 0);
        int count = 0;
        // visited[0] = 1;
        for(int i = 0 ; i < n ; i++){
            if(visited[i] == 1)
                continue;
            que.push(i);
            visited[i] = 1;
            while(!que.empty()){
                int curr = que.front();
                que.pop();
                
                for(int j = 0 ; j < adj[curr].size() ; j++){
                    if(visited[adj[curr][j]] != 1){
                        visited[adj[curr][j]] = 1;
                        que.push(adj[curr][j]);
                    }
                }
            }
            count++;
        
        }
        return count;
    }
};