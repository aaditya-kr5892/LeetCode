class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;

        for(int i = 0 ; i < k ; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        int l = 0, r = k;
        while(l <= r && r < s.length()){
            max = Math.max(max, count);
            if(isVowel(s.charAt(l))){
                count--;
            }
            if(isVowel(s.charAt(r))){
                count++;
            }
            r++;
            l++;
        }
        max = Math.max(max, count);
        return max;
    }
    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        return false;
    }
}