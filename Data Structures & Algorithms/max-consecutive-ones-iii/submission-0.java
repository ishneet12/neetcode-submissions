class Solution {
    public int longestOnes(int[] arr, int k) {
        int cntZ = 0 ;
        int n = arr.length;
        int l = 0 , r = 0;

        int maxlen = Integer.MIN_VALUE;
        while(r<n){

            if(arr[r]==0){
                cntZ++;
            }

            while(cntZ>k){
               if(arr[l]==0){
                cntZ--;
               } 
                l++;
            }

            maxlen = Math.max(maxlen,r-l+1);

            r++;
        }

        return maxlen;
    }
}