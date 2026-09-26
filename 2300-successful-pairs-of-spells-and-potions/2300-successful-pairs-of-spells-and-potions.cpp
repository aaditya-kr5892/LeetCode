class Solution {
public:
    vector<int> successfulPairs(vector<int>& spells, vector<int>& potions, long long success) {
        sort(potions.begin(), potions.end());
        int n = spells.size();
        vector<int> r (n, 0);
        
        for(int i = 0 ; i < spells.size() ; i++){
            int res = 0;
            int s = 0;
            int e = potions.size()-1;
            while(s <= e){
                int mid = e + (s-e)/2;
                long long p = (long long)spells[i] *(long long)potions[mid];
                // cout<< p<<endl;
                if(p >= success){
                    res += (e-mid+1);
                    e = mid -1;
                    // cout<<res<<endl;
                }
                else if(p < success){
                    s = mid + 1;
                }
                // cout<<res<<endl;
            }
            r[i] = res;
        }
        return r;
    }
};