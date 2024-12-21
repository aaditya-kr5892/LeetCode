class MyStack {
    Queue<Integer> qu1 ;
    Queue<Integer> qu2 ;
    public MyStack() {
        qu1 = new LinkedList<>();
        qu2 = new LinkedList<>();
    }
    
    public void push(int x) {
        qu1.add(x);
    }
    
    public int pop() {
        while(qu1.size()>1){
            qu2.add(qu1.poll());
        }
        int t = qu1.poll();
        //qu1.poll();
        Queue<Integer> temp = qu1;
        qu1 = qu2;
        qu2 = temp;
        return t;
    }
    
    public int top() {
        while(qu1.size()>1){
            qu2.add(qu1.poll());
        }
        int t = qu1.peek();
        qu2.add(qu1.poll());
        Queue<Integer> temp = qu1;
        qu1 = qu2;
        qu2 = temp;
        return t;
    }
    
    public boolean empty() {
        if(qu1.size() == 0) return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */