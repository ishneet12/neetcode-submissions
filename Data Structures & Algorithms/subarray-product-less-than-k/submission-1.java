class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        int n = arr.length;
        int cnt = 0 ;
        int p=1;

        if(k<=1){
            return 0;
        }

        int l = 0 , r = 0;

        while(r<n){

            p *= arr[r];

            while(l<=r && p>=k){
                p/=arr[l];
                l++;
            }

            cnt += r-l+1; 

            r++;
        }

        return cnt;
    }
}