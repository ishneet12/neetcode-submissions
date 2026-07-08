class Solution {

    public void dfs(int i , int j , int color , int curcolor ,int[][] image){
        if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j] != curcolor){
            return;
        }

        image[i][j] = color;


        dfs(i+1,j,color,curcolor,image);
        dfs(i-1,j,color,curcolor,image);
        dfs(i,j+1,color,curcolor,image);
        dfs(i,j-1,color,curcolor,image);

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        
        int n = image.length;
        int m = image[0].length;  

        int org = image[sr][sc];

        if(color==org) return image;

        dfs(sr,sc,color,org,image);

        return image;

        
    }
}