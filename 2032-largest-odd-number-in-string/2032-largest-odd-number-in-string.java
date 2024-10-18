class Solution {
    public String largestOddNumber(String num) {
        int i = 0 ; 
        int j = num.length()-1;
        while(j>=i){
            if((Character.getNumericValue(num.charAt(j)) % 2 != 0)){
                return num.substring(i,j+1);
            }
            else{
                j--;
            }
        }
        return "";
    }
}