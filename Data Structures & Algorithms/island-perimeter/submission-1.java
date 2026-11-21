class Solution {
    public int dfs(int i, int j, int grid[][], int vis[][]) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || j >= m || i >= n || grid[i][j] == 0) {
            return 1;
        }

        if (vis[i][j] == 1) {
            return 0;
        }
        vis[i][j] = 1;

        return dfs(i + 1, j, grid, vis) + dfs(i, j + 1, grid, vis) + dfs(i - 1, j, grid, vis)
            + dfs(i, j - 1, grid, vis);
    }
    public int islandPerimeter(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int vis[][] = new int[n][m];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    ans += dfs(i, j, grid, vis);
                }
            }
        }
        return ans;
    }
}