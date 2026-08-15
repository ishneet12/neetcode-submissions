class Solution {
    public int[] sortArrayByParity(int[] arr) {
        int n = arr.length;
        int i=0;
        int j=n-1;

        while(i<=j){
            if(arr[i]%2!=0 && arr[j]%2==0){
                // swap 
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

            if(arr[i]%2==0 && arr[j]%2!=0){
                i++;
                j--;
            }

            else if(arr[i]%2==0 && arr[j]%2==0){
                i++;
            }

            else if(arr[i]%2!=0 && arr[j]%2!=0){
                j--;
            }

        }
        return arr;
    }
}