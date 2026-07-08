class Solution {

    public void dfs(int r, int c, int[][] arr, int vis[][], int prevh) {
        int n = arr.length;
        int m = arr[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m || vis[r][c] == 1 || arr[r][c] < prevh)
            return;
        
        vis[r][c] = 1;

        dfs(r+1,c,arr,vis,arr[r][c]);
        dfs(r,c+1,arr,vis,arr[r][c]);
        dfs(r-1,c,arr,vis,arr[r][c]);
        dfs(r,c-1,arr,vis,arr[r][c]);
    }

    public List<List<Integer>> pacificAtlantic(int[][] arr) {

        int n = arr.length;
        int m = arr[0].length;

        int pac[][] = new int[n][m];
        int atl[][] = new int[n][m];



        for(int j=0;j<m;j++){
            dfs(0,j,arr,pac,arr[0][j]);
            dfs(n-1,j,arr,atl,arr[n-1][j]);
        }

        for(int i=0;i<n;i++){
            dfs(i,0,arr,pac,arr[i][0]);
            dfs(i,m-1,arr,atl,arr[i][m-1]);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pac[i][j]==1 && atl[i][j]==1){
                    ans.add(Arrays.asList(i,j));
                }
            }
        }
        return ans;
    }
}
