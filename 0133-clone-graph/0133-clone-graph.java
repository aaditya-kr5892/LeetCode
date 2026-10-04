/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> que = new LinkedList<>();
        que.add(node);
        Node n = new Node(node.val);
        map.put(node, n);
        // Set<Node> set = new HashSet<>();
        while(!que.isEmpty()){
            Node t = que.poll();
            // set.add(t);
            Node tn = map.get(t);
            for(Node ne : t.neighbors){
                
                if(map.containsKey(ne)){
                    tn.neighbors.add(map.get(ne));
                }
                else{
                    Node n2 = new Node(ne.val);
                    map.put(ne, n2);
                    tn.neighbors.add(n2);
                    que.add(ne);
                }
                
            }
        }
        return n;
    }
}