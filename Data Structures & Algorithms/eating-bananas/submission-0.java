class Solution {
    public boolean time(int arr[] , int mid , int h){
        int n = arr.length;

        int cnt = 0;

        for(int i=0;i<n;i++){
            cnt+=Math.ceil((double)arr[i]/(double)mid);
        }
        return cnt<=h;
    }
    public int minEatingSpeed(int[] arr, int h) {
        int low = 1, high = Integer.MIN_VALUE;

        for(int i=0;i<arr.length;i++){
            high = Math.max(arr[i],high);
        }
        int ans = high;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(time(arr,mid,h)){
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
