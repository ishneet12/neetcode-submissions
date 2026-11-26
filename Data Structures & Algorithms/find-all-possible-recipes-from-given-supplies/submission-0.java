class Solution {
    public List<String> findAllRecipes(String[] r, List<List<String>> ing, String[] s) {
        HashSet<String> st = new HashSet<>();
        
        for(int i=0;i<s.length;i++){
            st.add(s[i]);
        }
        List<String> ans = new ArrayList<>();
        for(int i=0;i<r.length;i++){
            int flag = 0;

            for(int j=0;j<ing.get(i).size();j++){
                if(!st.contains(ing.get(i).get(j))){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0 ){
                ans.add(r[i]);
                st.add(r[i]);
            }
        }
        return ans;
        
    }
}
