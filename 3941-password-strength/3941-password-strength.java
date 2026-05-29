class Solution {
    public int passwordStrength(String password) {
        Set<Character> set = new HashSet<>();
        for(char ch : password.toCharArray()){
            set.add(ch);
        }
        int res = 0;
        for(char ch:set){
            if(ch <= 90 && ch >= 65){
                res+=2;
            }
            else if(ch <= 122 && ch >= 97){
                res+=1;
            }
            else if(ch == '!'||ch== '@'||ch=='#' || ch =='$'){
                res+=5;
            }
            else{
                res+=3;
            }
        }
        return res;
    }
}