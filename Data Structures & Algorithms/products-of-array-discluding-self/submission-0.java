class Solution {
    public int[] productExceptSelf(int[] arr) {
        int n = arr.length;
        int ans[] = new int[n];
        int pre = 1;

        Arrays.fill(ans,1);
        for(int i=0;i<n;i++){
            ans[i]*=pre;
            pre*=arr[i];
        }

        int suf = 1;
        for(int i=n-1;i>=0;i--){
            ans[i] *= suf;
            suf*=arr[i]; 
        }

        return ans;
    }
}  
