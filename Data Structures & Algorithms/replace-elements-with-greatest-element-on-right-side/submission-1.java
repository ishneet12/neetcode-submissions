class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;

        int maxi = arr[n-1];
        arr[n-1] = -1;

        for(int i=n-2;i>=0;i--){
            if(arr[i]<maxi){
                arr[i] = maxi;
            }
            else{
                int temp = arr[i];
                arr[i] = maxi;
                maxi = temp;
            }
        }

        return arr;
    }
}