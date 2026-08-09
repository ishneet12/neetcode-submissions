class Solution {
    public int[] getConcatenation(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n+n];

        for(int i=0;i<n+n;i++){
            ans[i] = arr[i%n];
        }
        return ans;
    }
}