class Solution {
    public List<String> findAllRecipes(String[] r, List<List<String>> ing, String[] s) {
        HashMap<String, List<String>> adj = new HashMap<>();

        HashMap<String, Integer> indegree = new HashMap<>();

        for (int i = 0; i < r.length; i++) {
            indegree.put(r[i],ing.get(i).size());

            for (String k : ing.get(i)) {
                if (!adj.containsKey(k)) {
                    adj.put(k,new ArrayList<>());
                }
                adj.get(k).add(r[i]);
            }
        }

        Queue<String> qu = new LinkedList<>();
        List<String> ans = new ArrayList<>();
        for(int i=0;i<s.length;i++){
            qu.offer(s[i]);
        }

        while(!qu.isEmpty()){
            String cur = qu.poll();

            for(String it : adj.getOrDefault(cur , new ArrayList<>())){
                indegree.put(it , indegree.get(it)-1);
                if(indegree.get(it)==0){
                    qu.offer(it);
                    ans.add(it);
                }
            }
        }
        return ans;
    }
}
