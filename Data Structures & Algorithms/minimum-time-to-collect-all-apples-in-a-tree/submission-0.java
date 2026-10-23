class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int indegree[] = new int[n];
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegree[u]++;
            indegree[v]++;
        }

        int time[] = new int[n];
        Queue<Integer> qu = new LinkedList<>();
        for(int i=1;i<n;i++){
            if(indegree[i]==1){
                qu.offer(i);
            } 
            
        }

        while(!qu.isEmpty()){
            int cur = qu.poll();
            indegree[cur]--;
            for(int it : adj.get(cur)){
                if(indegree[it]==0){
                    continue;
                }

                indegree[it]--;
                if(hasApple.get(cur) || time[cur]>0){
                    time[it] += time[cur]+2;
                }
                if(indegree[it]==1 && it!=0){
                    qu.offer(it);
                }
            }
        }
        return time[0];
    }
}