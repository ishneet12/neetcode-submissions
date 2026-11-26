class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = roads.length+1;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[n];
        int pas[] = new int[n];
        Arrays.fill(pas,1);
        for(int it[] : roads){
            int u = it[0];
            int v = it[1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            indegree[u]++;
            indegree[v]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i=1;i<n;i++){
            if(indegree[i]==1){
                qu.offer(i);
            }
        }
        
        long ans = 0;
        while(!qu.isEmpty()){
            int node = qu.poll();

            ans +=  Math.ceil( (double) pas[node]/seats);

            for(int it : adj.get(node)){
                indegree[it]--;
                pas[it] += pas[node];
                if(indegree[it]==1 && it!=0){
                    qu.offer(it);
                }
            }
        }
        return ans;
    }
}
