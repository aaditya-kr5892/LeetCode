class Solution {
    public String reverseVowels(String s) {
        List<Character> list = new ArrayList<>();
        int j = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            if(isVowel(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        Collections.reverse(list);
        for(int i = 0 ; i < s.length() ; i++){
            if(isVowel(s.charAt(i))){
                sb.append(list.get(j));
                j++;
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();

    }
    boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U'){
            return true;
        }
        return false;
    }
}