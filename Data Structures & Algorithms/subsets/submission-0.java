class Solution {
    public List<List<Integer>> subsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int num : arr){
            int n = ans.size();

            for(int i=0;i<n;i++){
                List<Integer> ls = new ArrayList<>(ans.get(i));
                ls.add(num);
                ans.add(ls);
            }
        }
        return ans;
    }
}
