/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return f(root, p, q);
    }
    TreeNode f(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p || root == q){
            return root;
        }
        
        TreeNode l = f(root.left, p, q);
        TreeNode r = f(root.right, p, q);

        if(l != null && r != null) return root;

        return (l != null)?l:r;
    }
}