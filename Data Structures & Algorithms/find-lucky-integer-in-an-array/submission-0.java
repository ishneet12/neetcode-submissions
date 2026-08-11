class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int n = arr.length;
        int maxi = -1;
        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

        for(int i=0;i<n;i++){
            if(mp.get(arr[i])==arr[i]) maxi = Math.max(arr[i],maxi);
        }

        return maxi;
    }
}