/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray arr) {
        int n = arr.length();
        if(n<3) return -1;
        int low = 1 , high = n-2;
        int peak = 0;

        while(low<=high){
            int m = (high + low)/2;
            int mid = arr.get(m);
            int left = arr.get(m-1);
            int right = arr.get(m+1);

            if(left<mid && right<mid){
                peak = m;
                break;
            }
            else if(left<mid && mid<right){
                low = m+1;
            }
            else{
                high = m-1;
            }
        }
        low = 0 ;
        high = peak-1;

        while(low<=high){
            int mid = low+(high - low)/2;

            if(arr.get(mid)==target){
                return mid;
            }
            else if(arr.get(mid)<target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        low = peak ;
        high = n-1;

        while(low<=high){
            int mid = low+(high - low)/2;

            if(arr.get(mid)==target){
                return mid;
            }
            else if(arr.get(mid)>target){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return -1;

    }
}