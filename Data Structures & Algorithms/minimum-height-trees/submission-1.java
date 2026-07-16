class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> ls = new ArrayList<>();
            ls.add(0);
            return ls;
        }
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[n];
        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);

            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
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

                    if (indegree[it] == 1) {
                        qu.offer(it);
                    }
                }
            }
        }

        return new ArrayList<>();
    }
}