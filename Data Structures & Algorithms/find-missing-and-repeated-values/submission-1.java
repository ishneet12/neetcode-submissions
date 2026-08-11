class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int m = grid.length;
        int n = m*m;
        long sn = n*(n+1L)/2;
        long s2n = n*(n+1L) * (2L*n+1) / 6;

        long s = 0;
        long s2 = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                s+=grid[i][j];
                s2 += grid[i][j] * grid[i][j];
            }
        }

        long sumdiff = sn - s;//1
        long sqdiff = s2n - s2;//5

        long eq = sqdiff/sumdiff;

        long missing = (eq + sumdiff)/2;

        long repeated = eq - missing;

        int ans [] = new int[2];

        ans[0] = (int) repeated;
        ans[1] = (int) missing;

        return ans;

    }
}