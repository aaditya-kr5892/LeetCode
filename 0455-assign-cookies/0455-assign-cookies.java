class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int l = 0 ; 
        int r = 0 ;
        int count = 0 ;
        while(l < g.length && r < s.length){
            if(g[l] <= s[r]){
                l++;
                r++;
                count++;
            }
            else{
                r++;
            }
        }
        if(count != g.length){
            while(l == g.length-1 && r < s.length){
                if(g[l] > s[r])
                r++;
                else{
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}