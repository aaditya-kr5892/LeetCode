/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null ) return root;
        return f(root);
    }
    Node f(Node root){
        Queue<Node> que = new LinkedList<>();
        Node temp = root;
        que.add(root);
        
        while(!que.isEmpty()){
            // Node r = que.poll();
            Node prev = null;
            int s = que.size();
            for(int i = 0 ; i < s ; i++){
                Node r = que.poll();
                if(prev != null){
                    prev.next = r;
                    prev = r;
                }
                else{
                    r.next = null;
                    prev = r;
                }
                if(i == s-1) r.next = null;
                if(r.left != null) que.add(r.left);
                if(r.right != null) que.add(r.right);
            }
        }
        return temp;
    }
}