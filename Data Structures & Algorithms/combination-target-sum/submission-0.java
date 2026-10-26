class Solution {
     List<List<Integer>> ans ;
     List<Integer> ls;
    public  void rec(int arr[] , int idx , int sum , int t){
        if(idx>=arr.length){
            if(sum==t){
                ans.add(new ArrayList<>(ls));
            }
            return;
        }

        if(sum+arr[idx]<=t){
            ls.add(arr[idx]);
            rec(arr, idx, sum+arr[idx], t);
            ls.remove(ls.size()-1);
        }

        rec(arr, idx+1, sum, t);      
    }
    public List<List<Integer>> combinationSum(int[] arr, int target) {
         ans = new ArrayList<>();
        ls = new ArrayList<>();
        rec(arr, 0,0, target);
        return ans;
    }
}
