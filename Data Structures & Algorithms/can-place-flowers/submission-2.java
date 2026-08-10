class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int emp = arr[0]==0 ? 1 : 0; 
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                n -= (emp-1)/ 2;
                emp = 0;
            }
            else{
                emp++;
            }
        }
        n -= emp/2;
        return n<=0;
    }
}