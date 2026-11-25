class Solution {
    class pair{
        int node;
        int w;

        pair(int x , int y){
            node = x;
            w = y;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for( int it[] : times){
            adj.get(it[0]).add(new pair(it[1] , it[2]));
        }
        
        PriorityQueue<pair> qu = new PriorityQueue<>((x,y)->x.w-y.w);

        qu.offer(new pair(k,0));
        int vis[] = new int[n+1];

        Arrays.fill(vis,Integer.MAX_VALUE);
        vis[k] = 0;

        while(!qu.isEmpty()){
            pair cur = qu.poll();
            int node = cur.node;
            int wi = cur.w;

            for(pair it : adj.get(node)){
                if(wi + it.w < vis[it.node]){
                    vis[it.node] = wi + it.w;
                    qu.offer(new pair(it.node,wi + it.w));
                }
            }
        }

        int ans = -1;

        for(int i=1;i<=n;i++){
            if(vis[i]==Integer.MAX_VALUE){
                return -1;
            }

            ans = Math.max(ans,vis[i]);
        }

        return ans;
        
    }
}
