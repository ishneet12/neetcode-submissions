class Solution {
    public int[] twoSum(int[] arr, int t) {

        HashMap<Integer,Integer> mp = new HashMap<>();


        for(int i=0;i<arr.length;i++){
            int sum = arr[i];
            if(mp.containsKey(t - sum)){
                return new int[]{mp.get(t-sum),i};
            }
            mp.put(sum,i);
        }

        return new int[]{-1,-1};

    }
}
