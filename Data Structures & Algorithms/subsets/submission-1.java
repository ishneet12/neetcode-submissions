class Solution {
    List<List<Integer>> ans;

    public void sub(int arr[], int idx, List<Integer> ls) {
        if (idx >= arr.length) {
            ans.add(new ArrayList<>(ls));
            return ;
        }

        ls.add(arr[idx]);
        sub(arr, idx + 1, ls);
        ls.remove(ls.size() - 1);
        sub(arr, idx + 1, ls);

    }
    public List<List<Integer>> subsets(int[] arr) {
        ans = new ArrayList<>();
        sub(arr, 0, new ArrayList<>());
        return ans;
    }
}
