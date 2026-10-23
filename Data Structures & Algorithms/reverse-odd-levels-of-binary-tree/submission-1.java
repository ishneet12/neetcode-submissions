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
    public void reverse(TreeNode r1 , TreeNode r2 , int l){
        if(r1==null){
            return;
        }

        if(l%2==0){
            int temp = r1.val;
            r1.val = r2.val;
            r2.val = temp;
        }

        reverse(r1.left,r2.right,l+1);
        reverse(r1.right,r2.left,l+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        reverse(root.left,root.right,0);
        return root;
    }
}
