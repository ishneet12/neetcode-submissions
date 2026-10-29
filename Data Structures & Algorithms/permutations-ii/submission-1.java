class Solution {
    List<List<Integer>> ans;
    public void permute(int arr[], int idx) {
        if (idx == arr.length) {
            List<Integer> ls = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                ls.add(arr[i]);
            }
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            boolean duplicate = false;

            for (int j = idx; j < i; j++) {
                if (arr[j] == arr[i]) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                continue;
            }

            swap(arr, i, idx);
            permute(arr, idx + 1);
            swap(arr, i, idx);
        }
    }

    public void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        // ls = new ArrayList<>();
        Arrays.sort(nums);
        permute(nums, 0);
        return ans;
    }
}