class Solution {
    public int xor(int arr[] , int idx , int x){
        if(idx>=arr.length){
            return x;
        }

        int sum = 0;
        sum+=xor(arr,idx+1,x^arr[idx]);
        sum+=xor(arr,idx+1,x);

        return sum;
        
    }
    public int subsetXORSum(int[]arr) {
        return xor(arr,0,0);
    }
}