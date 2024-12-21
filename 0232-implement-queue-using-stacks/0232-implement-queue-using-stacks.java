class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>(); 
        st2 = new Stack<>();
    }
    
    public void push(int x) {
        st1.add(x);
    }
    
    public int pop() {
        int t = 0 ; 
        if(st2.size() != 0){
            t = st2.pop();
        }
        else{
            while(st1.size() >0){
                st2.add(st1.pop());
            }
            t = st2.pop();
        }
        return t;
    }
    
    public int peek() {
        int t = 0 ;
       if(st2.size() != 0){
            t = st2.peek();
        }
        else{
            while(st1.size() >0){
                st2.add(st1.pop());
            }
            t = st2.peek();
        }
        return t;
    }
    
    public boolean empty() {
        return (st1.size() == 0 && st2.size() == 0)?true:false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */