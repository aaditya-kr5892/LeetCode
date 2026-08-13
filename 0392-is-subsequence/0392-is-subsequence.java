class Solution {
    public boolean isSubsequence(String s, String t) {
        return sub(s, t, 0, 0);
    }
    boolean sub(String s, String t, int i, int j){
        if(j == s.length()){
            return true;
        }
        if(i == t.length()){
            return j == s.length();
        }

        if(s.charAt(j) == t.charAt(i)){
            return sub(s, t, i+1, j+1);
        }
        else{
            return sub(s, t, i+1, j);
        }
    }
}