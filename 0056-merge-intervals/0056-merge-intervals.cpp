class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end(), [](vector<int> a, vector<int> b){
            return a[0] < b[0];
        });
        vector<vector<int>> res;
        vector<int> c = intervals[0];
        res.push_back(c);
        for(int i = 1 ; i < intervals.size() ; i++){
            if(intervals[i][0] > res.back()[1]){
                res.push_back({intervals[i][0], intervals[i][1]});
            }
            else{
                if(intervals[i][1] <= res.back()[1]){
                    continue;
                }
                else{
                    // res.pop();
                    
                    vector<int> r = res.back();
                    res.pop_back();
                    res.push_back({min(r[0], intervals[i][0]), max(r[1], intervals[i][1])});
                    
                }
            }
            // c = res.back();
        }
        return res;
    }
};