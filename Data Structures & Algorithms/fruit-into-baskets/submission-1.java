class Solution {
    public int totalFruit(int[] arr) {
        HashMap<Integer,Integer> mp = new HashMap<>();
        int j=0;
        int n = arr.length;
        int maxlen = 0;
        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            if(mp.size()>2){
                mp.put(arr[j],mp.getOrDefault(arr[j],0)-1);
                if(mp.get(arr[j])==0){
                    mp.remove(arr[j]);
                }
                j++;
            }
            maxlen = Math.max(maxlen,i-j+1);
        }

        return maxlen;
    }
}