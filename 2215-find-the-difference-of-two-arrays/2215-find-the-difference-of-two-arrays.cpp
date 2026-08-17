class Solution {
public:
    vector<vector<int>> findDifference(vector<int>& nums1, vector<int>& nums2) {
        unordered_set<int> set1(nums1.begin(), nums1.end());
        unordered_set<int> set2(nums2.begin(), nums2.end());
        
        vector<int> ans1;
        vector<int> ans2;
        for(int num:set1){
            if(!set2.contains(num)) ans1.push_back(num);
        }
        for(int num : set2){
            if(!set1.contains(num)) ans2.push_back(num);
        }
        return {ans1, ans2};
    }
};