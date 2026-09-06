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
    vector<int> rightSideView(TreeNode* root) {
        queue<TreeNode*> que ;
        if(root == nullptr){
            return {};
        }
        vector<int> v; 
        que.push(root);
        while(!que.empty()){
            int s = que.size();
            for(int i = 0 ; i < s ; i++){
                TreeNode* r = que.front();
                que.pop();
                if(r->right != nullptr){
                    que.push(r->right);
                }
                if(r->left != nullptr){
                    que.push(r->left);
                }
                if(i == 0){
                    v.push_back(r->val);
                }
            }
        }
        return v;
    }
};