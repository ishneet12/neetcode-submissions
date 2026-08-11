class Solution {
    public boolean isMonotonic(int[] arr) {
        int i = 0, j = 0;
        int asc = 1;
        int n = arr.length;
        int dsc = 1;
        while (i < n - 1) {
            if (!(arr[i] <= arr[i + 1])) {
                asc = 0;
            } 
            if(!(arr[i] >= arr[i + 1])) {
                dsc = 0;
            }
            i++;
            j++;
        }
        
        if (asc == 1 || dsc == 1)
            return true;
        return false;
    }
}