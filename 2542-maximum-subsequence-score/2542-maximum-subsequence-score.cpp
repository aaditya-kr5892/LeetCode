class Solution {
public:
    long long maxScore(vector<int>& nums1, vector<int>& nums2, int k) {
        priority_queue<pair<int, int>> pq ;
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq2;
        for(int i = 0 ; i < nums2.size() ; i++){
            pq.push({nums1[i], i});
        }
        long long ans = 0;
        long long sum = 0;
        while(!pq.empty() && k > 0){
            pair<int, int> t = pq.top();
            sum+=t.first;
            pq2.push({nums2[t.second], t.second});
            pq.pop();
            k--;
        }
        ans = max(ans, sum*pq2.top().first);
        
        while(!pq.empty()){
            pair<int , int>t2 = pq2.top();
            pq2.pop();
            sum-=nums1[t2.second];
            pair<int, int> t = pq.top();
            pq.pop();
            sum+=t.first;
            pq2.push({nums2[t.second], t.second});
            ans = max(ans, sum*pq2.top().first);
        }
        return ans;
    }
};