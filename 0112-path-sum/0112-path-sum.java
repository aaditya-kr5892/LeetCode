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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        // if(root.left != null && root.right != null)
        return f(root, targetSum);
        
    }
    boolean f(TreeNode root, int target){
        if(root == null) return false;
        if (root.left == null && root.right == null) {
            return target == root.val;
        }
        // if(target == 0) return true;
        boolean l = false;
        boolean r = false;
        // if(target >= root.val){
        l = f(root.left, target-root.val);
        r = f(root.right, target-root.val);
        // }
        
        return l||r;
    }
}