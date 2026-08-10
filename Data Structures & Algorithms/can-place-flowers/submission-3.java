class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                boolean prev = (i == 0) || arr[i - 1] == 0;
                boolean next = (i == arr.length - 1) || arr[i + 1] == 0;

                if (prev && next) {
                    arr[i] = 1;
                    n--;
                }
            }
        }

        return n <= 0;
    }
}