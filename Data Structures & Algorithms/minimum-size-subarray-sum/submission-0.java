class Solution {
    public int minSubArrayLen(int t, int[] arr) {
        int i=0;
        int j=0;

        int n = arr.length;
        int minlen = Integer.MAX_VALUE;
        int sum = 0;
        while(j<n){
            sum+=arr[j];
            while(sum>=t){
                minlen = Math.min(j-i+1,minlen);
                sum-=arr[i];
                i++;
            }
            j++;
        }

        return minlen==Integer.MAX_VALUE ? 0 : minlen ;
    }
}