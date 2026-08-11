class Solution {
    public int heightChecker(int[] arr) {
        int sA[] = Arrays.copyOf(arr,arr.length);

        Arrays.sort(sA);
        int cnt = 0;
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(sA[i]!=arr[i]){
                cnt++;
            }
        }
        return cnt;
    }
}