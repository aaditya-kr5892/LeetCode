class Solution {
public:
    int maxPerformance(int n, vector<int>& speed, vector<int>& efficiency, int k) {
        long MOD = 1000000007;
        vector<pair<int, int>> p ;
        for(int i = 0 ; i < n ; i++){
            p.push_back({speed[i], efficiency[i]});
        }
        sort(p.begin(), p.end(), [](pair<int, int> a, pair<int, int> b){
            return a.second > b.second;
        });
        long sum = 0;
        long ans = 0;
        priority_queue<int, vector<int>, greater<int>> pq;
        for(int i = 0 ; i < k ; i++){
            pq.push(p[i].first);
            sum = (sum + p[i].first);
            ans = max(ans, (sum * p[i].second));
        }
        
        int j = k;
        while(j < n){
            int sm = pq.top();
            pq.pop();
            sum -= sm;
            sum = (sum + p[j].first)%MOD;
            ans = max(ans, (sum * p[j].second));
            pq.push({p[j].first});
            j++;
        }
        return (int)(ans%MOD);
    }
};