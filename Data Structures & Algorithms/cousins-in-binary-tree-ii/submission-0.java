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
    // if left subtree 
    // level sum = cousinSum(node of rightsubtree sum) + //siblingSum(nodes of left subtree) 
    public void changeVal(TreeNode root , List<Integer> ls , int d){
        if(root==null || d>ls.size()){
            return;
        }

        root.val = ls.get(d) -  root.val ;

        if(root.left!=null && root.right!=null){
            int siblingSum = root.left.val + root.right.val;
            root.left.val = root.right.val = siblingSum;
        }

        changeVal(root.left,ls,d+1);
        changeVal(root.right,ls,d+1);
    }
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();

        List<Integer> ls = new ArrayList<>();

        qu.offer(root);

        while(!qu.isEmpty()){
            int n = qu.size();
            int sum = 0;
            for(int i=0;i<n;i++){
                TreeNode temp = qu.poll();
                sum += temp.val;

                if(temp.left!=null){
                    qu.offer(temp.left);
                }
                if(temp.right!=null){
                    qu.offer(temp.right);
                }

            }
            ls.add(sum);
        }
        changeVal(root,ls,0);
        return root;

    }
}
