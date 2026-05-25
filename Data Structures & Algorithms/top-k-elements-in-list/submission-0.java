class Solution {
    public int[] topKFrequent(int[] arr, int k) {

        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = arr.length;

        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

       List<int[]> ls = new ArrayList<>();

        for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
            ls.add(new int[]{
                entry.getValue(),
                entry.getKey()
            });
        }
        ls.sort((a,b)->b[0]-a[0]);

        int ans[] = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = ls.get(i)[1];
        }
        return ans;
    }
}
