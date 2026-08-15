class Solution {
    public int removeDuplicates(int[] arr) {
        int i = 0;
        int j = 1;
        int n = arr.length;
        while (j < n) {
            if (arr[i] == arr[j]) {
                j++;
            } else {
                arr[i + 1] = arr[j];
                i++;
                j++;
            }
        }
        return i+1;
    }
}