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
        if(root==null) return  ans;
        boolean flag = true;

        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);

        while(!qu.isEmpty()){
            int n = qu.size();
            List<Integer> ls = new ArrayList<>();

            for(int i=0;i<n;i++){
                TreeNode temp = qu.poll();

                if(temp.left!=null){
                    qu.offer(temp.left);
                }

                if(temp.right!=null){
                    qu.offer(temp.right);
                }

                ls.add(temp.val);
            }

            if(!flag){
                Collections.reverse(ls);
            }
            flag = !flag;
            ans.add(ls);
        }
        return ans;
    }
}