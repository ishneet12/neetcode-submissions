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
    public int dfs(TreeNode root,int maxi){
        if(root==null) return 0;

        int ans = 0;
        if(root.val>=maxi){
            ans = 1;
        }

        maxi = Math.max(maxi,root.val);

        ans += dfs(root.left,maxi);
        ans += dfs(root.right,maxi);

        return ans;
    }
    public int goodNodes(TreeNode root) {
        return dfs(root,root.val);
    }
}
