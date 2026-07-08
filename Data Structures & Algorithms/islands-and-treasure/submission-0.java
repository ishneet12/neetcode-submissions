class Solution {
    class pair{
        int r;
        int c;
        int d;

        pair(int x , int y, int z){
            r = x;
            c = y;
            d = z;
        }
    }
    public void islandsAndTreasure(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        PriorityQueue<pair> pq = new PriorityQueue<pair>((x,y)->x.d - y.d);
        int INF = 2147483647;


        //int vis[][] = new int[n][m];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    pq.offer(new pair(i,j,0));
                    //vis[i][j] = 1;
                }
            }
        }

        while(!pq.isEmpty()){
            pair cur = pq.poll();
            int crow = cur.r;
            int ccol = cur.c;
            int curd = cur.d;

            int drow[] = {1,0,-1,0};
            int dcol[] = {0,-1,0,1};

            for(int i=0;i<4;i++){
                int nrow = crow + drow[i];
                int ncol = ccol + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol] != -1){
                    if(grid[nrow][ncol] > curd + 1){
                        //vis[nrow][ncol] = 1;
                        grid[nrow][ncol] = curd + 1;
                        pq.offer(new pair(nrow , ncol , curd + 1));
                    }
                }
            }
        }
    }
}
