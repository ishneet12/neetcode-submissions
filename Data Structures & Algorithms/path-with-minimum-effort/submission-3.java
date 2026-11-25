class Solution {
    class pair {
        int r, c, w;

        pair(int x, int y, int z) {
            r = x;
            c = y;
            w = z;
        }
    }
    public int minimumEffortPath(int[][] arr) {
       
        int n = arr.length;
        int m = arr[0].length;
        if(n==1 && m==1){
            return 0;
        }
        PriorityQueue<pair> qu = new PriorityQueue<>((x,y)-> x.w - y.w);

        qu.offer(new pair(0, 0, 0));

        int vis[][] = new int[n][m];

        for (int it[] : vis) {
            Arrays.fill(it, Integer.MAX_VALUE);
        }
        int dr[] = {1, -1, 0, 0};
        int dc[] = {0, 0, 1, -1};
        while (!qu.isEmpty()) {
            pair cur = qu.poll();

            int r = cur.r;
            int c = cur.c;
            int w = cur.w;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int diff = Math.max(Math.abs(arr[r][c] - arr[nr][nc]), w);
                    if (diff < vis[nr][nc]) {
                        vis[nr][nc] = diff;
                        qu.offer(new pair(nr, nc, diff));
                    }
                }
            }
        }
        return vis[n - 1][m - 1];
    }
}