class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String , Integer> mp = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }

        int cnt = 0;

        for(int i=0;i<n;i++){
            if(mp.get(arr[i])==1){
                cnt++;
            }
            if(cnt==k){
                return arr[i];
            }
        }
        return "";
    }
}