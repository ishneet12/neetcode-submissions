class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int indegree[] = new int[n];

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);

            indegree[u]++;
            indegree[v]++;
        }
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 1) {
                qu.offer(i);
            }
        }

        while (!qu.isEmpty()) {
            if (n <= 2) {
                return new ArrayList<>(qu);
            }
            int s = qu.size();

            for (int i = 0; i < s; i++) {
                int node = qu.poll();
                n--;
                for (int it : adj.get(node)) {
                    indegree[it]--;

                    if(indegree[it]==1){
                        qu.offer(it);
                    }
                }
            }
        }
        return new ArrayList<>();
    }
}