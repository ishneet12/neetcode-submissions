class Solution {
    public boolean canFinish(int n, int[][] graph) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int indegre[] = new int[n];

        for (int i = 0; i < graph.length; i++) {
            int a = graph[i][0];
            int b = graph[i][1];
            adj.get(a).add(b);
            indegre[b]++;
        }

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegre[i] == 0) {
                qu.add(i);
            }
        }

        // List<Integer> ans = new ArrayList<>();
        int cnt = 0;
        while (!qu.isEmpty()) {
            int cur = qu.poll();
            cnt++;
            for (int it : adj.get(cur)) {
                indegre[it]--;

                if (indegre[it] == 0) {
                    qu.add(it);
                }
            }
        }

        return cnt==n;
    }
}
