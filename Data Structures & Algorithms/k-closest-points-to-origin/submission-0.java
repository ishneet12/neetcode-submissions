class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y)-> 
            Integer.compare(
        (y[0]*y[0] + y[1]*y[1]),
        (x[0]*x[0] + x[1]*x[1])
    ));

        for(int p[] : points){
            pq.offer(p);

            if(pq.size()>k){
                pq.poll();
            }
        }

        int ans[][] = new int[k][2];

        int i=0;

        while(!pq.isEmpty()){
            ans[i] = pq.poll();
            i++;
        }
        return ans;





    }
}
