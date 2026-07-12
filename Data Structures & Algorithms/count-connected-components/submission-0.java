class Solution {
    public void dfs(int vis[] , List<List<Integer>> adj , int node){
        vis[node] = 1;

        for(int it : adj.get(node)){
            if(vis[it]!=1){
                dfs(vis,adj,it);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int ans = 0;

        int vis[] = new int[n];

        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                dfs(vis,adj,i);
                ans++;
            }
        }
        return ans;
    }
}
