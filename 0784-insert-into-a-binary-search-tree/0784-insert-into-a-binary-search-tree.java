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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode entry = new TreeNode(val);
        TreeNode temp = root;
        if(root == null)
        return entry;
        while(true){
            if(root.val < val){
                if(root.right != null)
                root = root.right;
                else{
                    root.right = entry;
                    break;
                }
            }
            else{
                if(root.left != null)
                root = root.left;
                else{
                    root.left = entry;
                    break;
                }
            }
        }
        return temp;
    }
}