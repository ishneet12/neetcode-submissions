class Solution {
    public int maximumDetonation(int[][] bombs) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = bombs.length;
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int x1 = bombs[i][0], y1 = bombs[i][1], r1 = bombs[i][2];
            for (int j = i + 1; j < n; j++) {
                int x2 = bombs[j][0], y2 = bombs[j][1], r2 = bombs[j][2];

                long dx = (long) x1 - x2;
                long dy = (long) y1 - y2;

                long d = dx * dx + dy * dy;

                if (d <= (long) r1 * r1) {
                    adj.get(i).add(j);
                }

                if (d <= (long) r2 * r2) {
                    adj.get(j).add(i);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Queue<Integer> qu = new LinkedList<>();
            qu.offer(i);
            int vis[] = new int[n];
            vis[i] = 1;

            int cnt = 1;

            while (!qu.isEmpty()) {
                int node = qu.poll();
                for (int it : adj.get(node)) {
                    if (vis[it] != 1) {
                        qu.offer(it);
                        vis[it] = 1;
                        cnt++;
                    }
                }
            }
            ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
