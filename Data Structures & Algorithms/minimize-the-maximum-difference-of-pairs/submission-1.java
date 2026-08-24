class Solution {
    public boolean check(int arr[] , int p , int mid){
        int i=0;
        int n = arr.length;
        int cnt = 0;

        while(i<n){
            if(i!=n-1 && Math.abs(arr[i]-arr[i+1])<=mid){
                cnt++;
                i+=2;
            }
            else{
                i+=1;
            }
        }
        return cnt>=p;
    }
    public int minimizeMax(int[] arr, int p) {
        Arrays.sort(arr);
        int n = arr.length;
        int low = 0 , high = arr[n-1];
        int ans = 0;
        while(low<=high){
            int mid = low+(high-low)/2;

            if(check(arr,p,mid)){
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