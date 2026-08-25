class Solution {
    public double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int n = arr1.length;
        int m = arr2.length;

        if (n > m) {
            return findMedianSortedArrays(arr2, arr1);
        }
        int len = n + m + 1;
        int left = len / 2;

        int low = 0, high = n;

        while (low <= high) {
            int mid = (low + high) / 2;

            int mid2 = left - mid;

            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;

            if (mid < n) {
                r1 = arr1[mid];
            }
            if (mid2 < m) {
                r2 = arr2[mid2];
            }

            if (mid - 1 >= 0) {
                l1 = arr1[mid - 1];
            }
            if (mid2 - 1 >= 0) {
                l2 = arr2[mid2 - 1];
            }

            if (l1 <= r2 && l2 <= r1) {
                if ((n + m) % 2 == 0) {
                    return (double) (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
                }
                return (double) Math.max(l1, l2);
            }

            if (l1 > r2) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0.0;
    }
}
