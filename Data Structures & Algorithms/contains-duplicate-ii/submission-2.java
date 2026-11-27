class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(mp.containsKey(arr[i])){
                int idx = mp.get(arr[i]);
                if(Math.abs(i-idx)<=k){
                    return true;
                }
            }
            mp.put(arr[i],i);
        }
        return false;
    }
}