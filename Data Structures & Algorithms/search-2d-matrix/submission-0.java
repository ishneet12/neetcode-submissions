class Solution {
    public boolean searchMatrix(int[][] mat, int t) {
        int n = mat.length;
        int m = mat[0].length;
        int low = 0 , high = n*m-1;

        while(low<=high){
            int mid = (low+high)/2;
            int r = mid/m , c = mid%m;
            if(mat[r][c]==t){
               return true;
            }
            else if(mat[r][c]<t){
                low = mid+1;
            }
            else{
                high = mid-1;
            }
        }
        return false;
    }
}
