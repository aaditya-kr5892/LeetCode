class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int h = 2*k-1;
        int g = k-1;
        label:
        for(int i = 0 ; i <(nums.size()-h) ; i++){
            for(int j = i ; j < i+g ; j++){
                if(!(nums.get(j+1) > nums.get(j)))
                    continue label;
            }
            for(int k1 = i+k ; k1 < i+h ; k1++){
                if(!(nums.get(k1+1) > nums.get(k1)))
                    continue label;
            }
            return true;
        }
        return false;
    }
}