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
    public boolean findSum(TreeNode root , int sum , int t){
        if(root==null) return false;
        sum+=root.val;
        if(root.left==null && root.right==null && sum == t){
            return true;
        }
        return findSum(root.left,sum,t) || findSum(root.right,sum,t);
        
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return findSum(root,0,targetSum);
    }
}