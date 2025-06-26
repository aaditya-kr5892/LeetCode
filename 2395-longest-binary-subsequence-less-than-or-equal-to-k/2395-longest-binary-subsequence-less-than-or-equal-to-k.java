class Solution {
    public int longestSubsequence(String s, int k) {
        if(s.isEmpty())
            return 1;
        int index = 0;
        long num = 0 ;
        int count = 0;
        for(int i = s.length()-1 ; i >= 0 ; i--){
            // int temp = num;
            if(s.charAt(i) == '1'){
                num += 1L << s.length()-1-i;
            }
            if(num > k){
                // num = temp;
                index = i;
                break;
            }
            count++;
        }
        for(int i = 0 ; i < index ; i++){
            if(s.charAt(i) == '0'){
                count++;
            }
        }
        return count;
        
    }
}