class Solution {
    public TreeNode createBinaryTree(int[][] d) {
        HashMap<Integer,TreeNode> mp = new HashMap<>();
        Set<Integer> ch = new HashSet<>();

        for(int it[] : d){
            int p = it[0];
            int c = it[1];

            if(!mp.containsKey(p)){
                mp.put(p,new TreeNode(p));
            }
            if(!mp.containsKey(c)){
                mp.put(c,new TreeNode(c));
            }

            if(it[2]==1){
                mp.get(p).left = mp.get(c);
            }
            else{
                mp.get(p).right = mp.get(c);
            }

            ch.add(c);
        }
        for(int it : mp.keySet()){
            if(!ch.contains(it)){
                return mp.get(it);
            }
        }
        return null;
    }
}
