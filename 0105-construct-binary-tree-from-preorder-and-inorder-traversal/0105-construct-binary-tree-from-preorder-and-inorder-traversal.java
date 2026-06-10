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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return f(preorder, inorder, 0, inorder.length-1, 0, preorder.length-1);
    }
    TreeNode f(int[] preorder, int[] inorder, int ins, int ine, int prs, int pre){
        if(ins > ine || prs > pre){
            return null;
        }
        int mid = -1;
        TreeNode root = new TreeNode(preorder[prs]);

        for(int i = ins ; i <= ine ; i++){
            if(root.val == inorder[i]){
                mid = i;
                break;
            }
        }
        int len = mid-ins;

        root.left = f(preorder, inorder, ins, mid-1, prs+1, prs+len);
        root.right = f(preorder, inorder, mid+1, ine, prs+len+1, pre);
        return root;
    }
}