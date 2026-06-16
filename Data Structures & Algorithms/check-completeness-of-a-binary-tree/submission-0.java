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
    public boolean isCompleteTree(TreeNode root) {
        
        Queue<TreeNode> qu = new LinkedList<>();

        qu.add(root);
        boolean nullSeen = false;
        while(!qu.isEmpty()){
            TreeNode temp = qu.poll();
            if(temp!=null){
                if(nullSeen) return false;
                qu.offer(temp.left);
                qu.offer(temp.right);
            }
            else{
                nullSeen = true;
            }
        }
        return true;
    }
}