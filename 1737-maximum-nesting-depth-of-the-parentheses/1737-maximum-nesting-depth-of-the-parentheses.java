class Solution {
    public int maxDepth(String s) {
        int currcount = 0 ;
        int max = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '(')
            currcount++;
            else if(s.charAt(i) ==')'){
                if(currcount >max)
                max = currcount ;
                currcount--;
            }
        }
        return max;
    }
}