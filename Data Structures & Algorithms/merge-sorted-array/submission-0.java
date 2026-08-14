class Solution {
    public void merge(int[] a1, int m, int[] a2, int n) {
        int j = 0;
        for(int i=m;i<a1.length && j<n;i++){
            a1[i] = a2[j];
            j++;
        }

        Arrays.sort(a1);
    }
}