class MedianFinder {
    PriorityQueue<Integer> lo;
    PriorityQueue<Integer> hi;
    public MedianFinder() {
        lo = new PriorityQueue<>(Collections.reverseOrder());
        hi = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(lo.isEmpty() && hi.isEmpty()){
            hi.add(num);
            return;
        }
        hi.add(num);
        int k = hi.poll();
        lo.add(k);
        if(hi.size() < lo.size()){
            k = lo.poll();
            hi.add(k);
            return;
        }
    }
    
    public double findMedian() {
        if((hi.size()+lo.size() )%2 == 0){
            return (hi.peek()+lo.peek())/2.0d;
        }
        else{
            return hi.peek();
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */