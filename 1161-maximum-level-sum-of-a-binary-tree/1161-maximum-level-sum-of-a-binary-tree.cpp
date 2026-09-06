/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxLevelSum(TreeNode* root) {
        queue<TreeNode*> que;
        que.push(root);
        int l = 1;
        int level = 1;
        int max = INT_MIN;
        while(!que.empty()){
            int s = que.size();
            int sum = 0;
            for(int i = 0 ; i < s ; i++){
                TreeNode* r = que.front();
                que.pop();
                if(r->left != nullptr){
                    que.push(r->left);
                }
                if(r->right != nullptr){
                    que.push(r->right);
                }
                sum+=(r->val);
            }
            if(max < sum){
                max = sum;
                level = l;
            }
            l++;
        }
        return level;
    }
};