class Solution {
    public int maxArea(int[] arr) {
        int maxArea = 0;
        int n = arr.length;
        int i = 0;
        int j = n-1;

        while(i<=j){
            
            int area = Math.min(arr[i],arr[j]) * (j-i);

            maxArea = Math.max(area , maxArea);

            if(arr[i]<=arr[j]){
                i++;
            }
            else{
                j--;
            }

        }
        return maxArea;
    }
}
