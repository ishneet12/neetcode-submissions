class Solution {
    class pair{
        int r;
        int c;
        int t;

        pair(int x, int y , int z){
            r = x;
            c = y;
            t = z;
        }
    }
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int fresh = 0;

        Queue<pair> qu = new LinkedList<>();

        int vis[][] = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    vis[i][j] = 2;
                    qu.add(new pair(i,j,0));
                }
               else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int maxtime = 0;
        while(!qu.isEmpty()){
            pair cur = qu.poll();

            int row = cur.r;
            int col = cur.c;
            int time = cur.t;

            maxtime = Math.max(time,maxtime);

            int drow[] = {1,0,-1,0};
            int dcol[] = {0,1,0,-1};

            for(int i=0;i<4;i++){
                int r = row + drow[i];
                int c = col + dcol[i];

                if(r>=0 && c>=0 && r<n && c<m && vis[r][c]==0 && grid[r][c]==1){
                    vis[r][c] = 1;
                    qu.offer(new pair(r,c,time+1));
                    fresh--;
                } 
            } 
        }

        return fresh==0 ? maxtime : -1;

    }
}
