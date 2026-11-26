class Solution {
    class tup{
        int node;
        int cost;

        tup(int x , int y){
            node = x;
            cost = y;
        }
    }
    class pair{
        int node;
        int cost;
        int steps;

        pair(int x , int y , int z){
            node = x;
            cost = y;
            steps = z;
        }
    }
    public int findCheapestPrice(int n, int[][] grid, int src, int dst, int k) {
        ArrayList<ArrayList<tup>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int it[] : grid){
            int u = it[0];
            int v = it[1];
            int c = it[2];

            adj.get(u).add(new tup(v,c));
        }

        Queue<pair> pq = new LinkedList<>();

        pq.offer(new pair(src,0,0));
        int vis[] = new int[n];
        Arrays.fill(vis,Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            pair cur = pq.poll();
            int node = cur.node;
            int cost = cur.cost;
            int steps = cur.steps;

            
            if(steps>k){
                continue;
            }

            for(tup it : adj.get(node)){
                if(cost + it.cost <vis[it.node]){
                    pq.offer(new pair(it.node,cost+ it.cost,steps+1));
                    vis[it.node] = cost + it.cost;
                }
            }
        }
        return vis[dst]==Integer.MAX_VALUE ? -1 : vis[dst];

    }
}
