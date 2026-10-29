class Solution {
     public static int solve(int col, char arr[][], int n,int leftRow[],
        int upperdiagonal[],int lowerdiagonal[]
     ) {
        if (col >= n) {
            return 1;
        }
        int cnt = 0;
        for (int row = 0; row < n; row++) {
            if (arr[row][col]=='.' && leftRow[row]==-1 &&
                lowerdiagonal[row+col]==-1 && upperdiagonal[n-1+col-row]==-1
            ) {
                arr[row][col] = 'Q';
                leftRow[row] = 1;
                lowerdiagonal[row+col] = 1;
                upperdiagonal[n-1+col-row] = 1;
                cnt += solve(col + 1, arr, n,leftRow,upperdiagonal,lowerdiagonal);
                leftRow[row] = -1;
                lowerdiagonal[row+col] = -1;
                upperdiagonal[n-1+col-row] = -1;
                arr[row][col] = '.';
            }
        }
        return cnt;
    }

    public int totalNQueens(int n) {

        char arr[][] = new char[n][n];
        int leftRow[] = new int[n];

        int upperdiagonal[] = new int[2*n-1];
        int lowerdiagonal[] = new int[2*n-1];

        Arrays.fill(leftRow,-1);
        Arrays.fill(upperdiagonal,-1);
        Arrays.fill(lowerdiagonal,-1);

        for (char a[] : arr) {
            Arrays.fill(a, '.');
        }

        return solve(0, arr, n , leftRow,upperdiagonal,lowerdiagonal);
    }
}