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
    public int rob(TreeNode root) {
        int ans[] = f(root);
        return Math.max(ans[0], ans[1]);
    }
    int[] f(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int left[] = f(root.left);
        int right[] = f(root.right);

        int curr[] = new int[2];
        curr[0] = root.val + left[1] + right[1];
        int maxL = Math.max(left[0], left[1]);
        int maxR = Math.max(right[0], right[1]);

        curr[1] = maxL+maxR;
        return curr;
    }
}