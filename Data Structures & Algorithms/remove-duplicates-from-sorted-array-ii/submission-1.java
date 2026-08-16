class Solution {
    public int removeDuplicates(int[] arr) {
        int l = 0 , r = 0;
        int n = arr.length;
        while(r<n){
            int cnt = 1;

            while(r+1<n && arr[r]==arr[r+1]){
                r++;
                cnt++;
            }

            for(int i=0;i<Math.min(cnt,2);i++){
                arr[l] = arr[r];
                l++;
            }
            r++;
        }
        return l;
    }
}