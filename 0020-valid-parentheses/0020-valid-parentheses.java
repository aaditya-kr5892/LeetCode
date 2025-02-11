class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == '{'|| s.charAt(i) == '('||s.charAt(i) == '[')
            st.add(s.charAt(i));
            else{
            if(st.empty())
            return false;
            char ch = st.peek();
            if((s.charAt(i) ==']' && ch == '[') || ( s.charAt(i) =='}' &&ch == '{') || (s.charAt(i) ==')' && ch == '('))
            ch = st.pop();
            else return false;
            }
        }
        return st.empty();
    }
}