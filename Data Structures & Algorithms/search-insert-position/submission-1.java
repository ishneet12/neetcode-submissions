class Solution {
    public int searchInsert(int[] arr, int t) {
        int n = arr.length;
        int ans = n;

        int low = 0, high = n-1;

        while(low<=high){
            int mid = (low+high)/2;

            if(arr[mid]>=t){
                ans = mid;
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return ans;
    }
}