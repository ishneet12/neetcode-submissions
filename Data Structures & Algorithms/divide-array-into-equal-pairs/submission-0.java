class Solution {
    public boolean divideArray(int[] arr) {
        int n = arr.length;
        int pair = n/2;

        HashMap<Integer,Integer> mp = new HashMap<>();

        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

        for(int val : mp.values()){
            pair -= val/2;
        }

        return pair==0;


    }
}