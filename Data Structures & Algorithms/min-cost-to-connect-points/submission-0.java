class Solution {
    class pair{
        int u,v,dis;

        pair(int x , int y , int d){
            u = x;
            v = y;
            dis = d;
        }
    }
    public int findParent(int node , int parent[]){
        if(node==parent[node]){
            return node;
        }

        int temp = parent[node];
        parent[node] = findParent(temp , parent);
        return parent[node];
    }


    public boolean union(int u , int v , int size[] , int parent[]){
        int ulp_u = findParent(u,parent);
        int ulp_v = findParent(v,parent);

        if(ulp_u==ulp_v){
            return false;
        }


        if(size[ulp_u] <= size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v]++;
        }

        else{
            parent[ulp_v] = ulp_u;
            size[ulp_u]++;
        }

        return true;
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int parent[] = new int[n];
        int size[] = new int [n];
        ArrayList<pair> adj = new ArrayList<>();
        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                int d = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adj.add(new pair(i,j,d));
            }
        }

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        Collections.sort(adj ,  (x,y)->x.dis - y.dis );
        int ans = 0;
        for(pair it : adj){
            if(union(it.u , it.v, size, parent)){
                ans+=it.dis;
            }
        }
        return ans;

    }
}
