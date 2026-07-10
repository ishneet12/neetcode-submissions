class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int it[] : edges) {
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }

        Queue<Integer> qu = new LinkedList<>();
        int vis[] = new int[n];
        qu.add(0);
        vis[0] = 1;

        while (!qu.isEmpty()) {
            int cur = qu.poll();

            for (int it : adj.get(cur)) {
                if (vis[it] != 1) {
                    qu.add(it);
                    vis[it] = 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (vis[i] == 0) {
                return false;
            }
        }

        return true;
    }
}
