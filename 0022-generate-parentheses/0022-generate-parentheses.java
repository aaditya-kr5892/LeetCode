class Solution {
    public List<String> generateParenthesis(int n) {
        List <String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int open = 0 ; 
        int close = 0 ; 
        generate(list,0,0,new StringBuilder() , n);
        return list;
    }
    void generate(List<String> list,int open , int close,StringBuilder sb,int n){
        if(open ==n && close ==n){
            list.add(sb.toString());
            return ;
        }
        if(open < n){
            sb.append("(");
            //open++;
            generate(list,open+1,close,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open){
            sb.append(")");
            //close++;
            generate(list,open,close+1,sb,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}