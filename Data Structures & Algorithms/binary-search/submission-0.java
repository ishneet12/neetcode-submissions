class Solution {
    public int search(int[] arr, int t) {
        int low = 0 , high = arr.length-1;
        int ans = -1;
        while(low<=high){
            int mid = low + (high - low)/2;

            if(arr[mid]==t){
                return mid;
            }
            else if(arr[mid]<t){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }

        return ans;
    }
}
