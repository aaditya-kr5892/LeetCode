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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        f(list, sb, root);
        return list;
    }
    void f(List<String> res, StringBuilder sb, TreeNode root){
        int prev = sb.length();
        if(root.left == null && root.right == null){
            sb.append(Integer.toString(root.val));
            res.add(sb.toString());
            sb.setLength(prev);
            return;
        }
        sb.append(Integer.toString(root.val));
        sb.append("->");
        if(root.left != null){
            f(res, sb, root.left);
        }
        if(root.right != null){
            f(res, sb, root.right);
        }
        sb.setLength(prev);
    }
}