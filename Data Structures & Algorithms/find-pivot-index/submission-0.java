class Solution {
    public int pivotIndex(int[]arr) {
        int total = 0;

        for(int i=0;i<arr.length;i++){
            total+=arr[i];
        }
        int lsum = 0;
        for(int i=0;i<arr.length;i++){
            int rsum = total - arr[i]-lsum;

            if(lsum==rsum){
                return i;
            }

            lsum += arr[i];
        }

        return -1;
    }
}