class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int cnt  = 0;
        int maxCnt = 0;
        int n = arr.length;

        for(int i=0;i<n;i++){
            if(arr[i]==1){
                cnt++;
               // maxCnt = Math.max(cnt,maxCnt);
            }
            else{
                cnt = 0;
            }
            maxCnt = Math.max(cnt,maxCnt);
        }
        return maxCnt;
    }
}