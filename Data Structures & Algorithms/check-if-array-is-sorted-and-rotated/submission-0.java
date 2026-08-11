class Solution {
    public boolean check(int[] arr) {
        int n = arr.length;
        int cnt = 0;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                cnt++;
            }
        }

       cnt += arr[n-1]>arr[0]? 1 : 0;

       return cnt<=1;
    }
}