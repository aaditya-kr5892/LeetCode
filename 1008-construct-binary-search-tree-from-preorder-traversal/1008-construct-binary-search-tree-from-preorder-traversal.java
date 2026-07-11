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
    public TreeNode bstFromPreorder(int[] pre) {
        int in[] = new int[pre.length];
        for(int i = 0 ; i < pre.length ; i++){
            in[i] = pre[i];
        }
        Arrays.sort(in);
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0 ; i < in.length ; i++){
            map.put(in[i], i);
        }
        return f(in, pre, 0, in.length-1, 0, pre.length-1, map);
    }
    TreeNode f(int []in, int[] pre, int in_s, int in_e, int pr_s, int pr_e, Map<Integer, Integer> map){
        if(in_s > in_e || pr_s > pr_e){
            return null;
        }
        TreeNode r = new TreeNode(pre[pr_s], null, null);
        int mid = map.get(pre[pr_s]);
        int len = mid- in_s;
        r.left = f(in, pre, in_s, mid-1, pr_s+1, pr_s+len, map);
        r.right = f(in, pre, mid+1, in_e, pr_s+len+1, pr_e, map);
        return r;
    }
}