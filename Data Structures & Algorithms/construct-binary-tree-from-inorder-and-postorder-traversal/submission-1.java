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
    public TreeNode build(int inSt, int inEnd, int in[] ,int postSt, int postEnd, int post[],
        HashMap<Integer, Integer> mp) {
        if (inSt > inEnd || postSt > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(post[postEnd]);
        int iRoot = mp.get(post[postEnd]);

        int numsleft = iRoot - inSt;

        root.left = build(inSt, iRoot - 1, in, postSt, numsleft + postSt - 1, post, mp);
        root.right = build(iRoot+1,inEnd , in , numsleft + postSt , postEnd-1,post,mp);

        return root;
    }
    public TreeNode buildTree(int[] in, int[] post) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for(int i=0;i<=in.length-1;i++){
            mp.put(in[i],i);
        }
       return build(0,in.length-1,in , 0 , post.length-1,post,mp);
    }
}