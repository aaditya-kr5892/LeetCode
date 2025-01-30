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
    int value;
    data(int value){
        this.value = value;
    }
 }
class Solution {
    public int maxPathSum(TreeNode root) {
        data d = new data(Integer.MIN_VALUE);
        int max = f(root,0,d);
        return d.value;
    }
    int f(TreeNode root,int sum , data maxsum){
        if(root == null){
            return 0;
        }
        int l = Math.max(0,f(root.left,sum,maxsum));
        int r = Math.max(0,f(root.right,sum,maxsum));
        if(l+r+root.val > maxsum.value)
        maxsum.value = l+r+root.val;
        return root.val+Math.max(l,r);
    }
}