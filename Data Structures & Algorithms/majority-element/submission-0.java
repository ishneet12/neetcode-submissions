class Solution {
    public int majorityElement(int[] arr) {
        int cnt= 1;
        int ele = arr[0];

        for(int i=1;i<arr.length;i++){
            if(cnt==0){
                ele = arr[i];
                cnt = 1;
            }
            else if(arr[i]==ele){
                cnt++;
            }
            else{
                cnt--;
            }
        }

        return ele;
    }
}