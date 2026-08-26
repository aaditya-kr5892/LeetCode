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
class Solution {
    int max_len = 0;
    public int longestZigZag(TreeNode root) {
        f(root, 0, 0);
        return max_len;
    }
    void f(TreeNode root, int c, int len){
        if(root == null){
            return;
        }
        
        max_len = Math.max(max_len, len);

        if(c == 0){
            f(root.left, 1, len+1);
            f(root.right, 0, 1);
        }
        else{
            f(root.right, 0, len+1);
            f(root.left, 1, 1);
        }
    }
}