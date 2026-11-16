class KthLargest {

    PriorityQueue<Integer> pq;
    int k ;
    public KthLargest(int x, int[] arr) {
        k = x;
        pq = new PriorityQueue<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);

            if(pq.size()>k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.add(val);

        if(pq.size()>k){
            pq.poll();
        }

        return pq.peek();
    }
}
