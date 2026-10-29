class Solution {

    public boolean dfs(int r , int c , String w ,int idx ,char [][] b){
        if(idx==w.length()){
            return true;
        }

        if(r<0 || c<0 || r>=b.length || c>=b[0].length || b[r][c]!=w.charAt(idx)){
            return false;
        }

        char temp = b[r][c];
        b[r][c] = '.';
        boolean f = dfs(r+1,c,w,idx+1,b) || dfs(r-1,c,w,idx+1,b) 
        || dfs(r,c+1,w,idx+1,b) || dfs(r,c-1,w,idx+1,b);

        b[r][c] = temp;
        return f;
        
    }
    public boolean exist(char[][] b, String word) {
        int n = b.length;
        int m = b[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(b[i][j]==word.charAt(0)){
                   if(dfs(i,j,word,0,b)){
                    return true;
                   }
                }
            }
        }
        return false;
    }
}
