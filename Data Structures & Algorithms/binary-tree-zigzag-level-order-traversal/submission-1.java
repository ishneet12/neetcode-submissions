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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root==null) return ans;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.add(root);

        boolean fl = true;
        while(!qu.isEmpty()){
            int n = qu.size();
            List<Integer> ls = new ArrayList<>();

            for(int i=0;i<n;i++){
                TreeNode del = qu.poll();

                if(del.left!=null){
                    qu.offer(del.left);
                }
                if(del.right!=null){
                    qu.offer(del.right);
                }

                ls.add(del.val);
            }

            if(!fl){
                Collections.reverse(ls);
            }
            ans.add(ls);
            fl = !fl;
        }
        return ans;
    }
}    
   