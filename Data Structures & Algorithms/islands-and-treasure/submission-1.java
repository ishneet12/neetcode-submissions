class Solution {
    class pair{
        int i;
        int j;
        int dis;

        pair(int x , int y , int z){
            i = x;
            j = y;
            dis = z;
        }
    }
    public void islandsAndTreasure(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<pair> qu = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 0){
                    qu.offer(new pair(i,j,0));
                }
            }
        }

        while(!qu.isEmpty()){
            pair cur = qu.poll();
            int curr = cur.i;
            int curc = cur.j;
            int dis = cur.dis;
            int dr[] = {1,-1,0,0};
            int dc[] = {0,0,1,-1};

            for(int i=0;i<4;i++){
                int nr = curr + dr[i];
                int nc = curc + dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m && grid[nr][nc]!=-1 && grid[nr][nc]!=0){
                    if(dis+1<grid[nr][nc]){
                        grid[nr][nc] = dis+1;
                        qu.offer(new pair(nr,nc,dis+1));
                    }
                }
            }
        }

    }
}
