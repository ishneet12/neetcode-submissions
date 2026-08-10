class Solution {
    public int maxAscendingSum(int[] arr) {
        int maxSum = 0;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            maxSum = Math.max(maxSum,sum);
            if(i==(arr.length-1)||arr[i]>=arr[i+1]){
                sum = 0;
            }
        }
        return maxSum;
    }
}