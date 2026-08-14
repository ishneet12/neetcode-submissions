class Solution {
    public void merge(int[] a1, int m, int[] a2, int n) {
        int len = m+n-1;
        int i = m-1;
        int j = n-1;
        while(i>=0 && j>=0){
            if(a1[i]>a2[j]){
                a1[len] = a1[i];
                i--;
            }
            else{
                a1[len] = a2[j];
                j--;
            }

            len--;
        }

        while(j>=0){
            a1[len] = a2[j];
            j--;
            len--;
        }
    }
}