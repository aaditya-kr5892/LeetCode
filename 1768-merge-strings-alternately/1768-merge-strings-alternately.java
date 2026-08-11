class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < word1.length() && j < word2.length()){
            if(k % 2 == 0){
                sb.append(word1.charAt(i));
                i++;
            }
            else{
                sb.append(word2.charAt(j));
                j++;
            }
            k++;
        }
        while(i < word1.length()){
            sb.append(word1.charAt(i));
            i++;
        }
        while(j < word2.length()){
            sb.append(word2.charAt(j));
            j++;
        }
        
        return sb.toString();
    }
}