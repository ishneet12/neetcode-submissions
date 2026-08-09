class Solution {
    public boolean hasDuplicate(int[] arr ) {
        boolean isTrue = false;

        HashSet<Integer> st = new HashSet<>();

        for(int i=0;i<arr.length;i++){
            if(st.contains(arr[i])){
                isTrue = true;
            }
            st.add(arr[i]);
        }
        return isTrue;
    }
}