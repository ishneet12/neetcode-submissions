class Solution {
    public int findMin(int[] arr) {
        int n = arr.length;
        int low = 0, high = n - 1;
        int mini = Integer.MAX_VALUE;
        while (low <= high) {
            int mid = (low+high)/2;

            if(arr[low]<=arr[mid]){
                mini = Math.min(arr[low],mini);
                low = mid+1;
            }
            else{
                mini=Math.min(arr[mid],mini);
                high = mid-1;
            }
        }

        return mini;
    }
}
