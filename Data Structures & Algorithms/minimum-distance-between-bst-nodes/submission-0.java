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
    public int minDiffInBST(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        List<Integer> ls = new ArrayList<>();
        while (!qu.isEmpty()) {
            int n = qu.size();
            int sum = 0;
            for (int i = 0; i < n; i++) {
                TreeNode del = qu.poll();
                if (del.left != null) {
                    qu.offer(del.left);
                }
                if (del.right != null) {
                    qu.offer(del.right);
                }
                ls.add(del.val);
            }
        }

        Collections.sort(ls);
        int n = ls.size();
        if(n==0 || n==1){
            return n;
        }
        int mini = Integer.MAX_VALUE;
        for(int i=0;i<n-1;i++){
            if(ls.get(i+1)-ls.get(i)<mini){
                mini = ls.get(i+1)-ls.get(i);
            }
        }
        return mini;
    }
}
