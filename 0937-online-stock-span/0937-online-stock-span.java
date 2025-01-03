class StockSpanner {
    Stack<pair> st ;
    int index = -1 ;
    public StockSpanner() {
        st = new Stack<>();
        index = -1 ;
    }  
    public int next(int price) {
        index++;
        while(!st.empty() && st.peek().first <= price){
            st.pop();
        }
        int ans = index - ((st.empty())?-1:st.peek().sec);
        st.add(new pair(price,index));
        return ans;
    }
}
class pair{
    int first ;
    int sec;
    pair(int first, int sec){
        this.first = first ;
        this.sec = sec;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */