class Solution {
    class pair{
        String node;
        double wei;

        pair(String x , double y){
            node = x;
            wei = y;
        }
    }

    public double bfs(String src , String target , HashMap<String , List<pair>> adj){

        if(!adj.containsKey(src) || !adj.containsKey(target)) return -1.0;

        Queue<pair> qu = new LinkedList<>();
        Set<String> vis = new HashSet<>();

        qu.offer(new pair(src,1.0));
        vis.add(src);

        while(!qu.isEmpty()){
            pair cur = qu.poll();
            String node = cur.node;
            double w = cur.wei;

            if(node.equals(target)){
                return w;
            }

            for(pair it : adj.get(node)){
                if(!vis.contains(it.node)){
                    vis.add(it.node);
                    qu.offer(new pair(it.node , w * it.wei));
                }
            }
        }
        return -1.0;
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        HashMap<String , List<pair>> adj = new HashMap<>();

        for(int i=0;i<equations.size();i++){
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);

            adj.putIfAbsent(a,new ArrayList<>());
            adj.putIfAbsent(b,new ArrayList<>());

            adj.get(a).add(new pair (b,values[i]));
            adj.get(b).add(new pair (a,1/values[i]));
        }

        double[] res = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            String src = queries.get(i).get(0);
            String target = queries.get(i).get(1);

            res[i] = bfs(src,target,adj);
        }

        return res;

    }
}