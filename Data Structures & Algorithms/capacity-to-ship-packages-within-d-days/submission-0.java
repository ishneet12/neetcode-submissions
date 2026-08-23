class Solution {
    public boolean help(int arr[] , int mid , int d){
        int sum = arr[0];
        int cnt = 1;
        for(int i=1;i<arr.length;i++){
            if(sum+arr[i]<=mid){
                sum += arr[i];
            }
            else if(sum+arr[i]>mid){
                sum=arr[i];
                cnt++;
            }
        }
        return cnt<=d;
    }
    public int shipWithinDays(int[] arr, int days) {
        int n = arr.length;

        int low = Integer.MIN_VALUE;

        int high = 0;
        int ans = 0;
        for(int i=0;i<n;i++){
            low = Math.max(arr[i],low);
            high += arr[i];
        }

        while(low<=high){

            int mid = (low+high)/2;

            if(help(arr,mid,days)){
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