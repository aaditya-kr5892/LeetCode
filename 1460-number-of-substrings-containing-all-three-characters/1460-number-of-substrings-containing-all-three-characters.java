class Solution {
    public int numberOfSubstrings(String s) {
        int l = 0 , r = 0 , count = 0, cA = 0, cB = 0, cC = 0; 
        while(r < s.length()){
            if(s.charAt(r) == 'a')
            cA++;
            else if(s.charAt(r) == 'b')
            cB++;
            else
            cC++;
            while(cA != 0 && cB != 0 && cC != 0){
                count += s.length()-r;
                if(s.charAt(l) == 'a')
                cA--;
                else if(s.charAt(l) == 'b')
                cB--;
                else
                cC--;
                l++;
            }
            if(cA == 0 || cB == 0 || cC == 0){
                r++;
            }
        }
        return count ;
    }
}