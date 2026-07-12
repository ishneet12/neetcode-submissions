class Solution {
    class pair {
        int r, c , d;

        pair(int x, int y,int z) {
            r = x;
            c = y;
            d = z;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1){
            return -1;
        }

        Queue<pair> qu = new LinkedList<>();

        int vis[][] = new int[n][n];

        for(int it[] : vis){
            Arrays.fill(it,Integer.MAX_VALUE);
        }
        qu.offer(new pair(0,0,1));
        vis[0][0] = 1;

        int ans = 0;

        while(!qu.isEmpty()){
            pair cur = qu.poll();
            int r = cur.r;
            int c = cur.c;
            int d = cur.d;

            int[] drow = {1, 0, -1, 0, -1, -1, 1, 1};
            int[] dcol = {0, 1, 0, -1, -1, 1, -1, 1};

            for(int i=0;i<8;i++){
                int nr = r + drow[i];
                int nc = c + dcol[i]; 
                int dis = d+1;

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc]==0){
                    if(dis < vis[nr][nc]){
                        qu.offer(new pair(nr,nc,dis));
                        vis[nr][nc] = dis;
                    }
                } 
            }
        }

        return vis[n-1][n-1] == Integer.MAX_VALUE ? -1 : vis[n-1][n-1]; 


    }
}