class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt = 0;
        int i=0;
        int maxcnt = 0;
        while(i<nums.length){
            if(nums[i]==1){
                cnt++;
            }
            else{
                maxcnt = Math.max(cnt,maxcnt);
                cnt=0;
            }
            i++;
        }
        return Math.max(cnt,maxcnt) ;
    }
}