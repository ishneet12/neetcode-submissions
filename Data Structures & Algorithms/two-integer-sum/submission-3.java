class Solution {
    public int[] twoSum(int[] arr, int t) {

        HashMap<Integer,Integer> mp = new HashMap<>();


        for(int i=0;i<arr.length;i++){
            int sum = t - arr[i];
            if(mp.containsKey(sum)){
                return new int[]{mp.get(sum),i};
            }
            mp.put(arr[i],i);
        }

        return new int[]{-1,-1};

    }
}
