class Solution {
    public int[] findOrder(int n, int[][] grid) {
         List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[n];

        for(int it[] : grid){
            adj.get(it[0]).add(it[1]);
            indegree[it[1]]++;
        }

        Queue<Integer> qu = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                qu.add(i);
            }
        }

        int j = 0;
        int arr[] = new int[n];
        while(!qu.isEmpty()){
            int cur = qu.poll();
            arr[n-1-j] = cur;
            j++;

            for(int it : adj.get(cur)){
                indegree[it]--;
                if(indegree[it]==0){
                    qu.offer(it);
                }
            }
        }
        if (j != n) {
            return new int[0];
        }
        return arr;
    }
}
