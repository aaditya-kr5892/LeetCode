class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int balance = 0 ;
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) =='('){
                if(balance >0){
                    sb.append(s.charAt(i));
                }
                balance++;
            }
            else{
                balance--;
                if(balance > 0){
                    sb.append(s.charAt(i));
                }
            }
        }
        return sb.toString();
    }
}