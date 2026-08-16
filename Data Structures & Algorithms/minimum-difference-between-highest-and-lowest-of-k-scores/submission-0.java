class Solution {
    public int minimumDifference(int[] arr, int k) {
        int n = arr.length;
        int l = 0;
        int r = k-1;
        int mini = Integer.MAX_VALUE;
        Arrays.sort(arr);
        
        while(r<n){
            mini = Math.min(mini , arr[r]-arr[l]);
            r++;
            l++;
        }

        return mini;
    }
}