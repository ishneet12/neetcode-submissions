class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int n = arr.length;
        int i = 0;
        int j = 0;

        while (j < n) {
           
            if (arr[j]%2==0) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                
                i++;
            }
            j++;

        }
        return arr;
    }
}