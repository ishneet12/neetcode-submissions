class Solution {
    public boolean dfs(int r, int c, int grid[][]) {

        for (int i = 0; i < grid[0].length; i++) {
            if (grid[r][i] == 1 && i != c) {
                return true;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            if (grid[i][c] == 1 && i != r) {
                return true;
            }
        }

        return false;

    }
    public int countServers(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    if (dfs(i, j, grid)) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}