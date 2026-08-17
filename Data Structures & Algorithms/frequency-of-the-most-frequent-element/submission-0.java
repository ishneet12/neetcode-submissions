class Solution {
    public int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int i=0 , j=0;
        int total = 0;
        int maxlen = 0;
        while(j<n){
            total += arr[j];

            while((long)(j-i+1) * arr[j] > total + k){
                total -= arr[i];
                i++; 
            }
            maxlen = Math.max(j-i+1,maxlen);
            j++;
        }

        return maxlen;
        
    }
}