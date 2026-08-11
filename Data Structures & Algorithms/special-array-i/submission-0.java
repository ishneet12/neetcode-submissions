class Solution {
    public boolean isArraySpecial(int[]arr) {
        int n = arr.length;
        int p = arr[0]%2==0 ? 0 : 1;
        for(int i=1;i<n-1;i++){
            if(arr[i]%2==0 && p==1){
                p=0;
            }
            else if(arr[i]%2!=0 && p==0){
                p=1;
            }
            else{
                return false;
            }
        }

        return true;

    }
}