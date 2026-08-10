class Solution {
    public int[] nextGreaterElement(int[] arr1, int[] arr2) {
        int n = arr2.length;
        int m = arr1.length;
        Stack<Integer> st = new Stack<>();

        int ans[] = new int[m];
        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr2[i] >= st.peek()) {
                st.pop();
            }
            if(!st.isEmpty()){
                mp.put(arr2[i], st.peek());
            }
            else{
                mp.put(arr2[i], -1);
            }
            st.push(arr2[i]);
        }

        for (int i = 0; i < m; i++) {
            if (mp.containsKey(arr1[i])) {
                ans[i] = mp.get(arr1[i]);
            }
        }
        return ans;
    }
}
