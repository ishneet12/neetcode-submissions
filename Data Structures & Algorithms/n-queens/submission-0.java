class Solution {
    List<List<String>> ans ;

    public void solve(int col , int n , int lr[] , int ld[] , int ud[] , char arr[][]){
        if(col>=n){
            List<String> ls = new ArrayList<>();
            for(char it[] : arr){
                ls.add(new String(it));
            }
            ans.add(ls);
            return;
        }


        for(int row = 0;row<n;row++){
            if(arr[row][col] == '.' && lr[row]==-1 && ld[row+col]==-1 && ud[n-1+(col-row)]==-1 ){
                arr[row][col] = 'Q';
                lr[row]=1;
                ld[row+col]=1;
                ud[n-1+(col-row)]=1;
                solve(col+1,n,lr,ld,ud,arr);
                arr[row][col] = '.';
                lr[row]=-1;
                ld[row+col]=-1;
                ud[n-1+(col-row)]=-1;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        ans = new ArrayList<>();

        char arr[][] = new char[n][n];
        int lr[] = new int[n];
        int ld[] = new int[2*n+1];
        int ud[] = new int[2*n+1];

        Arrays.fill(lr,-1);
        Arrays.fill(ld,-1);
        Arrays.fill(ud,-1);

        for(char it[] : arr){
            Arrays.fill(it,'.');
        }
        solve(0,n ,lr,ld,ud,arr);
        return ans;
    }
}
