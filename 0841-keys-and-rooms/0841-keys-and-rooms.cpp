class Solution {
public:
    bool canVisitAllRooms(vector<vector<int>>& rooms) {
        queue<int> que;
        vector<int> visited(rooms.size(), 0);
        que.push(0);
        while(!que.empty()){
            int curr = que.front();
            visited[curr] = 1;
            que.pop();
            for(int i = 0 ; i < rooms[curr].size() ; i++){
                if(visited[rooms[curr][i]] == 0)
                que.push(rooms[curr][i]);
            }

        }
        for(int i = 0 ; i < rooms.size() ; i++){
            if(visited[i] == 0){
                return false;
            }
        }
        return true;
    }
};