class Solution {
    class pair {
        int r, c;

        pair(int x, int y) {
            r = x;
            c = y;
        }
    }
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;

        Queue<pair> q2 = new LinkedList<>();

        int found = 0;

        int vis[][] = new int[n][m];

        for (int i = 0; i < n; i++) {
            if (found == 1)
                break;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    Queue<pair> q1 = new LinkedList<>();
                    q1.offer(new pair(i, j));
                    vis[i][j] = 1;
                    while (!q1.isEmpty()) {
                        pair cur = q1.poll();
                        int r = cur.r;
                        int c = cur.c;
                        q2.offer(cur);
                        

                        int drow[] = { 1, 0, -1, 0 };
                        int dcol[] = { 0, 1, 0, -1 };

                        for (int k = 0; k < 4; k++) {
                            int nr = r + drow[k];
                            int nc = c + dcol[k];

                            if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                                if (grid[nr][nc] == 1 && vis[nr][nc] == 0) {
                                    q1.offer(new pair(nr, nc));
                                    vis[nr][nc] = 1;
                                }
                            }
                        }
                    }
                    found = 1;
                    break;
                }
            }
        }
        int ans = 0;
        while (!q2.isEmpty()) {

            for (int i = q2.size(); i > 0; i--) {
                pair cur = q2.poll();
                int r = cur.r;
                int c = cur.c;

                int drow[] = { 1, 0, -1, 0 };
                int dcol[] = { 0, 1, 0, -1 };
                for (int k = 0; k < 4; k++) {
                    int nr = r + drow[k];
                    int nc = c + dcol[k];

                    if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        if (grid[nr][nc] == 1 && vis[nr][nc] == 0) {
                            return ans;
                        }
                        else if (grid[nr][nc] == 0 && vis[nr][nc] == 0) {
                            q2.offer(new pair(nr, nc));
                            vis[nr][nc] = 1;
                        }
                    }
                }
            }
            ans++;
        }
        return ans;
    }
}