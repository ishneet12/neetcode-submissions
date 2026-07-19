class Solution {
    class pair{
        int node;
        int cost;
        int stops;
        pair(int x , int y,int z){
            node = x;
            cost = y;
            stops = z;
        }
    }

     class tuple{
        int node;
        int cost;
        
        tuple(int x , int y){
            node = x;
            cost = y;
            
        }
    }
    
    public int findCheapestPrice(int n, int[][] edges, int src, int dst, int k) {
        ArrayList<ArrayList<tuple>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(new tuple(edges[i][1],edges[i][2]));
        }
        int vis[] = new int[n];
        Arrays.fill(vis,Integer.MAX_VALUE);
        Queue<pair> qu = new LinkedList<>();

        qu.offer(new pair(src,0,0));
        vis[src] = 0;

        while(!qu.isEmpty()){
            pair cur = qu.poll();
            int node = cur.node;
            int c = cur.cost;
            int s = cur.stops;

            //if(node==dst) return c;

            if(s>k) continue;

            for(tuple it : adj.get(node)){
                if(it.cost + c < vis[it.node] && s <= k){
                    qu.offer(new pair(it.node , it.cost + c , s+1));
                    vis[it.node] = it.cost + c;
                }
            }
        }
        return vis[dst] == Integer.MAX_VALUE ? -1 : vis[dst];
    }
}
