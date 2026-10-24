class Solution {
    public boolean search(ListNode head , TreeNode root){
        if(head==null) return true;

        if(root!=null && root.val == head.val){
            return search(head.next,root.left) || search(head.next , root.right);
        }

        return false;
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root==null){
            return false;
        }

        if(search(head,root)){
            return true;
        }

        return isSubPath(head,root.left) || isSubPath(head,root.right);
        
    }
}
