class Solution {
    static List<List<Integer>> a;
    static List<Integer> ls;

    public static void sub(int arr[], int idx) {
        a.add(new ArrayList<>(ls));

        for (int i = idx; i < arr.length; i++) {
            if (idx != i && arr[i] == arr[i - 1]) {
                continue;
            }
            ls.add(arr[i]);
            sub(arr, i + 1);
            ls.remove(ls.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] arr) {
        Arrays.sort(arr);
        a = new ArrayList<>();
        ls = new ArrayList<>();
        sub(arr, 0);
        return a;
    }
}
