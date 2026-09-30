class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int l = 0; int r = 0;
        Stack<String> st = new Stack<>();
        while(r < s.length()){
            if(s.charAt(r) != ' '){
                r++;
                continue;
            }
            else{
                // e = r-1;
                String str = s.substring(l, r);
                
                st.push(str);
                while(s.charAt(r) == ' ')
                    r++;
                l = r;
            }
            
        }
        st.push(s.substring(l, r));
        while(!st.isEmpty()){
            sb.append(st.peek());
            sb.append(' ');
            st.pop();
        }
        // sb = sb.trim();
        return sb.toString().trim();
    }
}