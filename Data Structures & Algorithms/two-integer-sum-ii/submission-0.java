class Solution {
    public int[] twoSum(int[] arr, int t) {
        int i=0;
        int j=arr.length-1;

        while(i<j){
            int sum = arr[i]+arr[j];

            if(sum>t){
                j--;
            }
            else if(sum<t){
                i++;
            }
            else{
                return new int[]{i+1,j+1};
            }
        }
        return new int[]{-1,-1};
    }
}
