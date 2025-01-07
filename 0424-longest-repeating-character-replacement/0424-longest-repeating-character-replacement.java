class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0 , r = 0 , max = 0,maxValue = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(r < s.length()){
            map.put(s.charAt(r),map.getOrDefault(s.charAt(r),0)+1);
            for (int value : map.values()) {
                if (value > maxValue) {
                    maxValue = value;
                }
            }
            if((r-l+1)-maxValue > k){
                map.put(s.charAt(l),map.get(s.charAt(l))-1);
                if(map.get(s.charAt(l)) == 0)
                map.remove(s.charAt(l));
                l++;
            }
            if((r-l+1)-maxValue <= k){
                max = (max > (r-l+1))?max:r-l+1;
                r++;
            }
        }
        return max;
    }
}