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
        while(root != null){
            if(root.val > Math.max(q.val,p.val)){
                root = root.left;
            }
            else if(root.val < Math.min(p.val,q.val)){
                root = root.right;
            }
            else return root;
        }
        return p;
    }
}