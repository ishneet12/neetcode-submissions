class Solution {
    public int[] twoSum(int[] arr, int t) {
        int n = arr.length;
        int A[][] = new int[arr.length][2];
        for(int i=0;i<n;i++){
            A[i][0] = arr[i];
            A[i][1] = i;
        }
        Arrays.sort(A,Comparator.comparingInt(a -> a[0]));
        int i = 0;
        int j=arr.length-1;
        while(i!=j){
            int sum = A[i][0] + A[j][0];
            if(sum==t){
                return new int[]{Math.min(A[i][1],A[j][1]),Math.max(A[i][1],A[j][1])};
            }
            else if(sum>t){
                j--;
            }
            else{
                i++;
            }
        }
        return new int[]{-1,-1};
    }
}
