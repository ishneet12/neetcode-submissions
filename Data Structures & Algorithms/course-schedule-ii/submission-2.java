class Solution {
    public int[] findOrder(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
       
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[n];
        for(int it[] : edges){
            int u = it[0];
            int v = it[1];
            indegree[u]++;
            adj.get(v).add(u);
        }
        Queue<Integer> qu = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                qu.offer(i);
            }
        }
        int j=0;
        int ans[] = new int[n];
        while(!qu.isEmpty()){
            int cur = qu.poll();
            ans[j] = cur;
            j++;

            for(int it : adj.get(cur)){
                indegree[it]--;

                if(indegree[it]==0){
                    qu.offer(it);
                }
            }
        }

        if(j!=n){
            return new int[0];
        }

        return ans;
    }
}
