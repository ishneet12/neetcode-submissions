class Solution {
    public TreeNode build(int arr[] , int st , int ei){
        if(st>ei){
            return null;
        }

        int mid = (st+ei)/2;

        TreeNode root = new TreeNode(arr[mid]);
        root.left = build(arr,st,mid-1);
        root.right = build(arr,mid+1,ei);

        return root;
        
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums,0,nums.length-1);

    }
}
