class Solution {
    public boolean hasDuplicate(int[] arr) {
       HashSet<Integer> st = new HashSet<>();
       int n = arr.length;
       for(int i=0;i<n;i++){
        if(st.contains(arr[i])){
            return true;
        }
        st.add(arr[i]);
       } 
       return false;
    }
}