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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null)
        return list;
        st.add(root);
        while(!st.empty()){
            root = st.pop();
            list.add(root.val);
            if(root.right != null)
            st.add(root.right);
            if(root.left != null)
            st.add(root.left);
        }
        return list;
    }
}