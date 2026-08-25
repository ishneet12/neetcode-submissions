class Solution {
    public int first(int arr[] , int t){
        int low = 0 , high = arr.length-1;
        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid]==t){
                ans = mid;
                high = mid-1;
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

    public int last(int arr[] , int t){
        int low = 0 , high = arr.length-1;
        int ans = -1;

        while(low<=high){
            int mid = low+(high-low)/2;

            if(arr[mid]==t){
                ans = mid;
                low = mid+1;
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

    public int[] searchRange(int[] nums, int target) {
        return new int[]{first(nums,target) , last(nums,target)};
    }
}