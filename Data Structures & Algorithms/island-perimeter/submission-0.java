class Solution {
    private int dfs(int[][] grid, int vis[][], int i, int j) {
        if (i < 0 || i >=grid.length || j < 0 || j >=grid[0].length || grid[i][j] == 0) {
            return 1;
        }

        if (vis[i][j] == 1) {
            return 0;
        }
        vis[i][j] = 1;
        return dfs(grid, vis, i + 1, j)
        + dfs(grid, vis, i - 1, j)
        + dfs(grid, vis, i, j + 1)
        + dfs(grid, vis, i, j - 1);
    }
    public int islandPerimeter(int[][] grid) {
        int vis[][] = new int[grid.length][grid[0].length];
        int ans = 0;
        for (int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    ans+=dfs(grid,vis,i,j);
                }
            }
        }
        return ans;
    }
}