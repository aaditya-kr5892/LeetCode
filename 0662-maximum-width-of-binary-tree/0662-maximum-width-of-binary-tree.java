/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class data{
    int ind;
    TreeNode node;
    data(int ind, TreeNode node){
        this.ind = ind;
        this.node = node;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<data> que = new LinkedList<>();
        que.add(new data(0,root));
        int max = 0;
        while(!que.isEmpty()){
            int s = que.size();
            int min = que.peek().ind;
            int first = 0, last = 0;
            for(int i = 0 ; i < s ; i++){
                data d = que.poll();
                int n = d.ind - min;
                if(i == 0) first = n;
                if(i == s-1) last = n;
                if(d.node.left != null){
                    que.add(new data(2*n+1, d.node.left));
                }
                if(d.node.right != null){
                    que.add(new data(2*n+2, d.node.right));
                }
            }
            max = Math.max(max, last-first+1);
        }
        return max;
    }
}