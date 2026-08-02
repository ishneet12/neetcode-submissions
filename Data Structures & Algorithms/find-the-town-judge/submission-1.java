class Solution {
    public int findJudge(int n, int[][] trust) {
        
        int ind[] = new int[n+1];
        int outd[] = new int[n+1];

        for(int i=0;i<trust.length;i++){
            int u = trust[i][0];
            int v = trust[i][1];

            ind[v]++;
            outd[u]++;

        }

        for(int i=1;i<=n;i++){
            if(ind[i]==n-1 && outd[i]==0){
                return i;
            }
        }

        return -1;


    }
}