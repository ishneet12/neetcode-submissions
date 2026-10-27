class Solution {
    public boolean mergeTriplets(int[][] arr, int[] t) {
        int n = arr.length;
        int ans[] = new int[3];

        Arrays.fill(ans,-1);
        for(int it[] : arr){
            if(it[0]>t[0] || it[1]>t[1] || it[2]>t[2]){
                continue;
            }

            for(int i=0;i<3;i++){
                if(t[i]==it[i]){
                    ans[i] = it[i];
                }
            }
        }

        for(int i=0;i<3;i++){
            if(ans[i]==-1){
                return false;
            }
        }
        return true;
    }
}
