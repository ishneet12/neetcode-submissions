class Solution {
    public void moveZeroes(int[] arr) {
        int i=0;
        int n = arr.length;
        int j = 0;

        while(j<n){
            if(arr[j]!=0){
                // swap 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
            j++;
        }

    }
}