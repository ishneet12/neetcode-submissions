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
    public TreeNode dfs(int [] in  , int inst , int inend , int post[] , int postst , int postend,HashMap<Integer,Integer>mp){
        if(inst>inend || postst>postend){
            return null;
        }
        TreeNode root = new TreeNode(post[postend]);

        int inRoot = mp.get(root.val);
        int numsLeft = inRoot - inst;

        root.left = dfs(in , inst , inRoot-1, post,postst, postst+numsLeft-1,mp);
        root.right = dfs(in , inRoot+1 , inend, post,postst+numsLeft , postend-1,mp);

        return root;

    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer,Integer>mp = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            mp.put(inorder[i],i);
        }
        return dfs(inorder,0,inorder.length-1,postorder,0,postorder.length-1,mp);
    }
}