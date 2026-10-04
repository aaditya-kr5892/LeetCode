class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        vector<vector<pair<int, int>>> adj(n + 1);
        for(int i = 0 ; i < times.size() ; i++){
            adj[times[i][0]].push_back({times[i][1], times[i][2]});
        }
        auto cmp = [](pair<int, int> a, pair<int, int> b){
            return a.second > b.second;
        };
        vector<int> visited(n+1, INT_MAX);
        priority_queue<pair<int, int>, vector<pair<int, int>>, decltype(cmp)>pq(cmp);
        pq.push({k, 0});
        visited[k] = 0;
        
        while(!pq.empty()){
            auto [u, d] = pq.top();
            pq.pop();
            if(d > visited[u]) continue;

            for(auto [v, w] : adj[u]){
                if(d+w < visited[v]){
                    visited[v] = d+w;
                    pq.push({v, visited[v]});
                }
            }
        }
        int maxTime = 0;
        for(int i = 1 ; i < visited.size() ; i++){
            if(visited[i] == INT_MAX) return -1;
            maxTime = max(maxTime, visited[i]);
        }
        return maxTime;
    }
};