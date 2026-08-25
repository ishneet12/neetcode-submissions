class Solution {
    public boolean help(int arr[] , int k , int mid){
        int maxs = 0;
        int s = 1;

        for(int it : arr){
            if(maxs+it<=mid){
                maxs+=it;
            }
            else{
                s++;
                maxs = it;
            }
            if(s>k) return false;
        }
        return true;
    }
    public int splitArray(int[] arr, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for(int i=0;i<arr.length;i++){
            low = Math.max(arr[i],low);
            high+=arr[i];
        }
        int ans = 0;
        while(low<=high){
            int mid = (low+high)/2;
            
            if(help(arr,k,mid)){
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