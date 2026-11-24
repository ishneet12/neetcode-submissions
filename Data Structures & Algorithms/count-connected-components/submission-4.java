class Solution {
    public int findParent(int node , int parent[]){
        if(node==parent[node]){
            return node;
        }

        int temp = parent[node];
        parent[node] = findParent(temp,parent);
        return parent[node];
    }

    public void union(int u , int v , int size[] , int parent[]){
        int ulp_u = findParent(u,parent);
        int ulp_v = findParent(v , parent);
        if(ulp_u==ulp_v){
            return;
        }
        else if(size[ulp_u]<=size[ulp_v]){
            parent[ulp_u] = ulp_v;
            size[ulp_v]+=size[ulp_u];
        }
        else{
            parent[ulp_v] = ulp_u;
            size[ulp_u]++;
        }
    }
    public int countComponents(int n, int[][] edges) {
        int size[] = new int[n];
        int parent[] = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
        }

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];

            union(u,v,size,parent);
        }
        int ans = 0;
        for(int i=0;i<n;i++){
            if(parent[i]==i){
                ans++;
            }
        }
        return ans;


    }
}
