class Solution {
    public int findParent(int node,List<Integer> parent){
        if(node == parent.get(node)){
            return node;
        }
        int res = findParent(parent.get(node),parent);
        parent.set(node , res);
        return res;

    }
    public boolean unionBySize(int u , int v , List<Integer> parent , List<Integer> size){
        int ulpu = findParent(u,parent);
        int ulpv = findParent(v,parent);

        if(ulpu==ulpv){
            return true;
        }

        if(size.get(ulpu)>size.get(ulpv)){
            parent.set(ulpv,ulpu);
            size.set(u , size.get(u)+1);
        }
        else if(size.get(ulpv)>size.get(ulpu)){
            parent.set(ulpu,ulpv);
            size.set(v , size.get(v)+1);
        }
        else{
            parent.set(ulpu,ulpv);
            size.set(v , size.get(v)+1);
        }
        return false;
    }
    public int[] findRedundantConnection(int[][] edges) {

        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        for(int i=0;i<=edges.length;i++){
            parent.add(i);
            size.add(1);
        }

        for(int it[] : edges){
            int u = it[0];
            int v = it[1];
            if(unionBySize(u,v,parent,size)){
                return it;
            }
        }
        return new int[0];

    }
}
