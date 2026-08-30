class Solution {
    public int cnt_Subarrays(int arr[], int goal) {
        if (goal < 0) return 0;
        int sum = 0;
        int l = 0, r = 0;
        int n = arr.length;
        int cnt = 0;
        while (r < n) {
            sum += arr[r];

            while (l<n && sum > goal) {
                sum -= arr[l];
                l++;
            }

            cnt += (r - l + 1);

            r++;
        }

        return cnt;
    }
    public int numSubarraysWithSum(int[] arr, int goal) {
        return cnt_Subarrays(arr, goal) - cnt_Subarrays(arr, goal - 1);
    }
}