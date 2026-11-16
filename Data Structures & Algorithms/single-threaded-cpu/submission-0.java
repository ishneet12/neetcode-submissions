class Solution {
    public int[] getOrder(int[][] arr) {
         int n = arr.length;

        Integer idx[] = new Integer[n];

        for(int i=0;i<n;i++){
            idx[i] = i;
        }

        Arrays.sort(idx , (x,y)->
            arr[x][0]!=arr[y][0] ? arr[x][0]-arr[y][0] : x-y
        );


        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->
            arr[x][1]!=arr[y][1] ? arr[x][1]-arr[y][1] : x-y
        );


        int ans [] = new int[n];
        int i=0;

        int ansI = 0;
        int time = 0;

        while(!pq.isEmpty() || i<n){
            while(i < n && arr[idx[i]][0]<=time){
                pq.offer(idx[i]);
                i++;
            }
            if(pq.isEmpty()){
                time = arr[idx[i]][0];
            }else{
                int nextIdx = pq.poll();
                time+=arr[nextIdx][1];
                ans[ansI] = nextIdx;
                ansI++;
            }
        }
        return ans;
    }
}