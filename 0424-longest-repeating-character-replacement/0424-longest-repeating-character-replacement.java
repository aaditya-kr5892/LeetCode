class Solution {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int l = 0 ; 
        int r = 0 ;
        int res = 0;
        int max = 0;
        while(l <= r && r < s.length()){
            freq[s.charAt(r)-'A']++;
            max = Math.max(max, freq[s.charAt(r)-'A']);
            
            while((r-l+1)-max > k){
                freq[s.charAt(l)-'A']--;
                l++;
            }
            
            res = Math.max(res, (r-l+1));
            r++;
        }
        return res;
    }
}