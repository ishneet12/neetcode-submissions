class Solution {
    public int arrangeCoins(int n) {
        int ans = 0;
        int high = n;
        int i = 1;
        while (i <= high) {
            high = high - i;
            ans++;
            i++;
        }

        return ans;
    }
}