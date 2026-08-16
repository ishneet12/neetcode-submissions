class Solution {
    public boolean containsNearbyDuplicate(int[] arr, int k) {

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<arr.length;i++){
            if(mp.containsKey(arr[i])){
                int idx1 = mp.get(arr[i]);
                if(Math.abs(idx1-i)<=k){
                    return true;
                }
            }
            mp.put(arr[i],i);
        }
        return false;
    }
}