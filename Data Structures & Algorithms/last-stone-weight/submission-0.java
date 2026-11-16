class Solution {
    public int lastStoneWeight(int[] arr) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->y-x);
        int n = arr.length;
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);
        }

        while(pq.size()>1){
            int p1 = pq.poll();
            int p2 = pq.poll();

            if(p1==p2){
                continue;
            }
            else if(p2<p1){
                pq.offer(p1-p2);
            }
        }
        return pq.isEmpty()? 0 : pq.poll(); 
    }
}
