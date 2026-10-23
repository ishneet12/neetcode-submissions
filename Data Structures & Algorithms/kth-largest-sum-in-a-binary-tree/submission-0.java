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
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> ls = new ArrayList<>();

        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);
        int l = 0;
        while(!qu.isEmpty()){
            int n = qu.size();
            long sum = 0;
            for(int i=0;i<n;i++){
                TreeNode cur = qu.poll();

                sum+=cur.val;

                if(cur.left!=null){
                    qu.offer(cur.left);
                }
                if(cur.right!=null){
                    qu.offer(cur.right);
                }
            }
            ls.add(sum);
        }

        if(ls.size()<k){
            return -1;
        }

        ls.sort(Collections.reverseOrder());
        return ls.get(k-1);
    }
}
