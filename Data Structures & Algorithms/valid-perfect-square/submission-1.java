class Solution {
    public boolean isPerfectSquare(int n) {
        long low = 0 , high = n;
        while(low<=high){
            long mid=low+(high-low)/2;
            long res = mid*mid;
            if(res==n){
                return true;
            }

            else if(res<n){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}