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
    public boolean isValidBST(TreeNode root) {
        return f(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    boolean f(TreeNode root, long l, long u){
        if(root == null) return true;
        if(l >= root.val) return false;
        if(u <= root.val) return false;
        boolean le = f(root.left, l, (long)root.val);
        boolean r = f(root.right, (long)root.val, u);
        if(le == false || r == false) return false;
        return true;
    }
}