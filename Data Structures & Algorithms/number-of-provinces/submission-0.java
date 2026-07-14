class Solution {
    public void dfs(int i, int grid[][], int vis[]) {

        vis[i] = 1;

        for(int it=0;it<grid.length;it++ ){
            if(vis[it] != 1 && grid[i][it]==1){
                dfs(it,grid,vis);
            }
        }
    }
    public int findCircleNum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[] = new int[n];

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0 ) {
                dfs(i, grid, vis);
                ans++;
            }
        }
        return ans;
    }
}