class Solution {
    public String sortVowels(String s) {
        int freq[] = new int[123];
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'a'||s.charAt(i) == 'e'||s.charAt(i) == 'i'||s.charAt(i) == 'o'||s.charAt(i) == 'u'||s.charAt(i) == 'A'||s.charAt(i) == 'E'||s.charAt(i) == 'O'||s.charAt(i) == 'I'||s.charAt(i) == 'U'){
                freq[(int)s.charAt(i)]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < freq.length ; i++){
            while(freq[i] > 0){
                sb.append((char)i);
                freq[i]--;
            }
        }
        int ind = 0;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'a'||s.charAt(i) == 'e'||s.charAt(i) == 'i'||s.charAt(i) == 'o'||s.charAt(i) == 'u'||s.charAt(i) == 'A'||s.charAt(i) == 'E'||s.charAt(i) == 'O'||s.charAt(i) == 'I'||s.charAt(i) == 'U'){
                res.append(sb.charAt(ind));
                ind++;
            }
            else{
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}