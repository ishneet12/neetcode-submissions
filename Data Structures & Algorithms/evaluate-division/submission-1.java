class Solution {
    class pair{
        String node;
        double w;

        pair(String x , double y){
            node = x;
            w = y;
        }
    }

    public double bfs(String src , String tar ,  HashMap<String,List<pair>> adj){
        if(!adj.containsKey(src) || !adj.containsKey(tar) ){
            return -1.0;
        }

        Queue<pair> qu = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        qu.offer(new pair(src,1.0));
        vis.add(src);
        while(!qu.isEmpty()){
            pair cur = qu.poll();
            String node = cur.node;
            double we = cur.w;

            if(node.equals(tar)){
                return we;
            }

            for(pair it : adj.get(node)){
                if(!vis.contains(it.node)){
                    qu.offer(new pair(it.node , we*it.w));
                    vis.add(it.node);
                }
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> eq, double[] val, List<List<String>> q) {
        HashMap<String,List<pair>> adj = new HashMap<>();
        int n = val.length;
        for(int i=0;i<n;i++){
            String u = eq.get(i).get(0);
            String v = eq.get(i).get(1);

            adj.putIfAbsent(u,new ArrayList<>());
            adj.putIfAbsent(v,new ArrayList<>());

            adj.get(u).add(new pair(v,val[i]));
            adj.get(v).add(new pair(u,1/val[i]));
        }

        double ans[] = new double[q.size()];

        for(int i=0;i<q.size();i++){
            String u = q.get(i).get(0);
            String v = q.get(i).get(1);

            ans[i] = bfs(u,v,adj);
        }
        return ans;
    }
}