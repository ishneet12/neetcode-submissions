class Solution {
    static List<List<Integer>> ans ;
    static List<Integer> ls;
    public void rec(int n , int k , int idx){
        if(ls.size()==k){
            ans.add(new ArrayList<>(ls));
            return;
        }

        for(int i=idx;i<=n;i++){
            ls.add(i);
            rec(n,k,i+1);
            ls.remove(ls.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        ls = new ArrayList<>();
        rec(n,k,1);
        return ans;
    }
}