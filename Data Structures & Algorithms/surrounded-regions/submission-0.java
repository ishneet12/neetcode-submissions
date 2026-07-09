class Solution {

    public void dfs(int i , int j , int vis[][] , char[][] board ){
        int n = board.length;
        int m = board[0].length;

        if( i<0 || i>=n || j<0 || j>=m ) return;

        if(vis[i][j]==1 || board[i][j] !='O'){
            return;
        }

        vis[i][j] = 1;

        dfs(i+1,j,vis,board);
        dfs(i,j+1,vis,board);
        dfs(i-1,j,vis,board);
        dfs(i,j-1,vis,board);

    }
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int vis[][] = new int[n][m];

        for(int i=0;i<n;i++){
            if(board[i][0]=='O' && vis[i][0]==0){
                dfs(i,0,vis,board);
            }
            if(board[i][m-1]=='O' && vis[i][m-1]==0){
                dfs(i,m-1,vis,board);
            }
        }

        for(int j=0;j<m;j++){
            if(board[0][j]=='O' && vis[0][j]==0){
                dfs(0,j,vis,board);
            }
            if(board[n-1][j]=='O' && vis[n-1][j]==0){
                dfs(n-1,j,vis,board);
            }
        }


        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='O' && vis[i][j]==0){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
