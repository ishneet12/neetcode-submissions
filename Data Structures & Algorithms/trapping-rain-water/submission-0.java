class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int lmax = arr[0];
        int rmax = arr[n - 1];

        int l = 0;
        int r = n - 1;
        int ans = 0;

        while (l < r) {
            if (lmax <= rmax) {
                l++;

                lmax = Math.max(arr[l], lmax);
                ans += lmax - arr[l];
            }

            else {
                r--;

                rmax = Math.max(arr[r], rmax);
                ans += rmax - arr[r];
            }
        }

        return ans;
    }
}
