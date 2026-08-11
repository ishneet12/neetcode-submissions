class Solution {
    public List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        int st[] = new int[n+1];
        for(int i=0;i<n;i++){
            st[arr[i]]++;
        }

        for(int i=1;i<=n;i++){
            if(st[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}