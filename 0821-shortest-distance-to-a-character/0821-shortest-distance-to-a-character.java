class Solution {
    public int[] shortestToChar(String s, char c) {
        int last = -1;
        int suf[] = new int[s.length()];
        for(int i = suf.length-1 ; i >= 0 ; i--){
            if(s.charAt(i) == c){
                suf[i] = 0;
                last = i;
                continue;
            }
            if(last == -1){
                suf[i] = -1; 
                continue;
            }
            suf[i] = last-i;
        }
        last = -1;
        int ans[] = new int[s.length()];
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == c){
                ans[i] = 0;
                last = i;
            }
            else{
                if(last != -1 && suf[i] != -1){
                    ans[i] = Math.min(Math.abs(i-last), suf[i]);
                }
                else if(last == -1){
                    ans[i] = suf[i];
                }
                else if(suf[i] == -1){
                    ans[i] = i-last;
                }
            }
        }

        return ans;
    }
}