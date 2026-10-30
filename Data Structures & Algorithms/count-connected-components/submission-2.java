class Solution {
    public void dfs(int i, int vis[], ArrayList<ArrayList<Integer>> adj) {
        vis[i] = 1;

        for (int it : adj.get(i)) {
            if (vis[it] != 1) {
                dfs(it, vis, adj);
            }
        }
    }
    public int countComponents(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int cnt = 0;
        int vis[] = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] != 1) {
                dfs(i,vis,adj);
                cnt++;
            }
        }
        return cnt;
    }
}
