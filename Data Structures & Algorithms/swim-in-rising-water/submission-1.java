class Solution {
    class pair{
        int i,j,h;
        pair(int x , int y , int k){
            i = x;
            j = y;
            h = k;
        }
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n==1){
            return grid[0][0];
        }
      PriorityQueue<pair> qu = new PriorityQueue<>((x,y)-> x.h - y.h);

      qu.offer(new pair(0,0, grid[0][0]));

      int vis[][] = new int[n][m];
      for (int it[] : vis) {
            Arrays.fill(it, Integer.MAX_VALUE);
        }
        int dr[] = {1, -1, 0, 0};
        int dc[] = {0, 0, 1, -1};
        while (!qu.isEmpty()) {
            pair cur = qu.poll();

            int r = cur.i;
            int c = cur.j;
            int w = cur.h;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m) {
                    int diff = Math.max(w,  grid[nr][nc]);
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
