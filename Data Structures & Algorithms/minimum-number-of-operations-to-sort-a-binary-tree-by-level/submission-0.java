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

    public int helper(List<Integer> ls){
        int n = ls.size();
        int arr[] = new int[n];

        for(int i=0;i<n;i++){
            arr[i] = ls.get(i);
        }

        Arrays.sort(arr);

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            mp.put(ls.get(i),i);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(ls.get(i)!=arr[i]){
                ans++;

                int cur = ls.get(i);
                int idx = mp.get(arr[i]);

                ls.set(i,arr[i]);
                ls.set(idx,cur);

                mp.put(arr[i],i);
                mp.put(cur,idx);
            }
        }
        return ans;
    }
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);
        int ans = 0;
        while(!qu.isEmpty()){
            List<Integer> ls = new ArrayList<>();
            int n = qu.size();

            for(int i=0;i<n;i++){
                TreeNode temp = qu.poll();
                ls.add(temp.val);

                if(temp.left!=null){
                    qu.offer(temp.left);
                }
                if(temp.right!=null){
                    qu.offer(temp.right);
                }
            }
            ans += helper(ls);
        }
        return ans;
    }
}
