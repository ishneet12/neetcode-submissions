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
    public void reverse(TreeNode rl ,TreeNode rr,int l){
        if(rl==null){
            return;
        }

        if(l%2==0){
            int temp = rl.val;
            rl.val = rr.val;
            rr.val = temp;
        }

        reverse(rl.left,rr.right,l+1);
        reverse(rl.right,rr.left,l+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left,root.right,0);
        return root;
    }
}
