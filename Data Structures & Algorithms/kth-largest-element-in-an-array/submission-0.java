class Solution {
    public int findKthLargest(int[] arr, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            pq.offer(arr[i]);

            if(pq.size()>k){
                pq.poll();
            }
        }

        return pq.peek();
    }
}
