class Solution {
    public int maxProfit(int[] arr) {
        int l = 0;
        int r = 0;

        int maxP = 0;
        int n = arr.length;
        while(r<n){
            if(arr[r]-arr[l]>maxP){
                maxP = arr[r]-arr[l];
            }

            if(arr[r]<arr[l]){
                l = r;
            }
            r++;
        }
        return maxP;
    }
}
