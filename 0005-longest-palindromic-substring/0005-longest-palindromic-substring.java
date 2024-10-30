class Solution {
    public String longestPalindrome(String s) {
        
        int start = 0 ;
        int maxlen = 1;
        for(int i = 1 ; i < s.length() ; i++){
            int l = i-1;
            int r = i;
            while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 >maxlen){
                    maxlen = r-l+1;
                    start = l;
                }
                r++;
                l--;
            }
            l = i-1;
            r = i+1;
            while(l>=0 && r < s.length() && s.charAt(l) == s.charAt(r)){
                if(r-l+1 >maxlen){
                    maxlen = r-l+1;
                    start = l;
                }
                r++;
                l--;
            }
        }
        return s.substring(start,start +maxlen);
    }
}