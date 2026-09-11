class SmallestInfiniteSet {
public:
    priority_queue<int, vector<int>, greater<int>> pq;
    unordered_set<int> set;
    SmallestInfiniteSet() {
        set = unordered_set<int>();
        pq = priority_queue<int, vector<int>, greater<int>>();
        for(int i = 1 ; i <= 1000 ; i++){
            pq.push(i);
            set.insert(i);
        }
    }
    
    int popSmallest() {
        int r = pq.top();
        pq.pop();
        set.erase(r);
        return r;
        
    }
    
    void addBack(int num) {
        if(set.find(num) == set.end()){
            pq.push(num);
            set.insert(num);
        }
        // pq.push(num);
    }
};

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet* obj = new SmallestInfiniteSet();
 * int param_1 = obj->popSmallest();
 * obj->addBack(num);
 */