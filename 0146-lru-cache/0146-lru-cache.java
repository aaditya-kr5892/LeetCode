class node{
    int val;
    int key;
    node prev;
    node next;
    node(int val, int key, node prev, node next){
        this.key = key;
        this.val = val;
        this.prev = prev;
        this.next = next;
    }
}

class LRUCache {
    node head, tail;
    Map<Integer, node> map ;
    int cap;
    public LRUCache(int capacity) {
        head = new node(-1, -1, null, null);
        tail = new node(-1, -1, null, null);
        map = new HashMap<>();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        else{
            node curr = map.get(key);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            node t = head.next;
            head.next = curr;
            curr.prev = head;
            curr.next = t;
            t.prev = curr;
            return map.get(key).val;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            node curr = map.get(key);
            curr.val = value; 
            
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            
            node t = head.next;
            head.next = curr;
            curr.prev = head;
            curr.next = t;
            t.prev = curr;
            return;
        }
        node t = new node(value, key, null, null);
        node n = head.next;
        head.next = t;
        n.prev = t;
        t.next = n;
        t.prev = head;
        map.put(key, t);
        if(map.size() <= cap){
            return;
        }
        else{
            node n1 = tail.prev.prev;
            node k = tail.prev;
            map.remove(k.key);
            n1.next = tail;
            tail.prev = n1;
            k.next = null;
            k.prev = null;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */