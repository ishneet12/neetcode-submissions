class Solution {

    public int dfs(int r , int c, int grid[][]){
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length){
            return 0 ;
        }
        if(grid[r][c]==0){
            return 0;
        }

        grid[r][c] = 0;

        return 1 + dfs(r+1,c,grid) + dfs(r-1,c,grid) + dfs(r,c+1,grid) + dfs(r,c-1,grid);
    }
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxi = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    int val = dfs(i,j,grid);
                    maxi = Math.max(maxi , val);
                }
            }
        }
        return maxi;
    }
}
