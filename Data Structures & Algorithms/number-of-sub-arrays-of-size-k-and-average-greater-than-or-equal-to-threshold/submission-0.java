class Solution {
    public int numOfSubarrays(int[] arr, int k, int th) {
        int cnt = 0 , l = 0 , r = 0;
        int n = arr.length;
        int sum = 0;

        while(r<n){
            sum+=arr[r];

            if(r-l>k-1){
                sum-=arr[l];
                l++;
            }

            if(r-l==k-1){
                int avg = sum/k;
                if(avg>=th){
                    cnt++;
                }
            }
            r++;
        }
        return cnt;
    }
}