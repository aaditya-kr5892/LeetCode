class Solution {
    public String longestCommonPrefix(String[] strs) {
        int j = -1;
        for(int i = 0 ; i < strs.length ; i++){
            j = 0 ; 
            while(j < strs[0].length() && j < strs[i].length() && strs[0].charAt(j) == strs[i].charAt(j)){
                j++;
            }
            strs[0] = strs[0].substring(0,j);
            if(strs[0].equals(""))
            return "";
        }
        return strs[0].substring(0,j);
    }
}