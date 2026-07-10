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
        return f(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1);
    }
    TreeNode f(int[] inorder, int[] preorder, int in_s, int in_e, int pr_s, int pr_e){
        if(in_s > in_e || pr_s > pr_e){
            return null;
        }
        int mid = -1;
        TreeNode r = new TreeNode(preorder[pr_s], null, null);
        for(int i = in_s ; i <= in_e ; i++){
            if(inorder[i] == preorder[pr_s]){
                mid = i;
                break;
            }
        }
        int len = mid - in_s;
        r.left = f(inorder, preorder, in_s, mid-1, pr_s+1, pr_s+len);
        r.right = f(inorder, preorder, mid+1, in_e, pr_s+len+1, pr_e);
        return r;
    }
}