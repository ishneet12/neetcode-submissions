class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] edges, int[][] q) {
        List<Boolean> ans = new ArrayList<>();

        ArrayList<Set<Integer>> adj = new ArrayList<>();

        ArrayList<Set<Integer>> st = new ArrayList<>();
        int indegree[] = new int[n];

        for(int i=0;i<n;i++){
            adj.add(new HashSet<>());
            st.add(new HashSet<>());
        }

        for(int it[] : edges){
            int u = it[0];
            int v = it[1];

            indegree[v]++;
            adj.get(u).add(v);

        }

        Queue<Integer> qu = new LinkedList<>();

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                qu.offer(i);
            }
        }
        while(!qu.isEmpty()){
            int node = qu.poll();

            for(int it : adj.get(node)){
                st.get(it).add(node);
                st.get(it).addAll(st.get(node));

                indegree[it]--;

                if(indegree[it]==0){
                    qu.offer(it);
                }
            }
        }

        
        for(int it[] : q){
            
            

            if(st.get(it[1]).contains(it[0])){
                ans.add(true);
            }
            else{
               ans.add(false);
            }
            
        }

        return ans;
    }
}