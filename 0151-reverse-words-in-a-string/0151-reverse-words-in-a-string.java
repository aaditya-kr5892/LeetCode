class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        int l = 0, r = 0;
        while(l <= r && r < s.length()){
            char ch = s.charAt(r);
            if(ch == ' '){
                list.add(s.substring(l, r));
                l = r+1;
                while(r < s.length() && s.charAt(r) == ' '){
                    r++;
                    l = r;
                }
                continue;
            }
            r++;
        }
        list.add(s.substring(l, r));
        Collections.reverse(list);
        for(int i = 0 ; i < list.size() ; i++){
            sb.append(list.get(i));
            sb.append(' ');
        }
        String st = sb.toString();
        return st.trim();
    }
}