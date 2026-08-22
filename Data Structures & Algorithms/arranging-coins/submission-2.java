class Solution {
    public int arrangeCoins(int n) {
        int ans = 0;
        int low = 0;
        int high = n;
        while(low<=high){
            int mid = low+(high-low)/2;

            long reqCoins = (long) mid*(mid+1)/2;

            if(reqCoins<=n){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return ans;
    }
}