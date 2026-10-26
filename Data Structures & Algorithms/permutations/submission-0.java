class Solution {
    List<List<Integer>> ans;
    List<Integer> ls;
    int vis[];
    public void per(int arr[]) {
        if (ls.size() == arr.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (vis[i] != 1) {
                ls.add(arr[i]);
                vis[i] = 1;
                per(arr);
                vis[i] = 0;
                ls.remove(ls.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] arr) {
        int n = arr.length;
        ans = new ArrayList<>();
        ls = new ArrayList<>();
        vis = new int[n];
        per(arr);
        return ans;
    }
}
