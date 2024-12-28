class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()){
            return "0";
        }
        Stack<Integer> st = new Stack<>();
        int i = 0 ;
        for(i = 0 ; i < num.length() ; i++){
            while(!st.empty() && st.peek() > num.charAt(i)-'0' && k>0){
                st.pop();
                k--;
            }
            if(k == 0)
            break;
            st.add(num.charAt(i) - '0');
        }
        while(i != num.length()){
            st.add(num.charAt(i)-'0');
            i++;
        }
        while(!st.empty() && k > 0){
            st.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(st.size() != 0){
            sb.append(st.pop());
        }
        int count = 0 ;
        for(int i1 = sb.length()-1 ; i1>= 0 ; i1--){
            if(sb.charAt(i1) == '0')
            count++;
            else
            break;
        }
        sb.setLength(sb.length()-count);
        if(sb.isEmpty())
        return "0";
        sb.reverse();
        return sb.toString();
    }
}