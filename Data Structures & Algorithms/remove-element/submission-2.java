class Solution {
    public int removeElement(int[] nums, int val) {

        if(nums.length==0){
            return 0;
        }
        int i=0;
        int n = nums.length;
        while(i< n && nums[i]!=val){
            i++;
        }

        int j = i;
        

        while(j<n){
            if(nums[j]!=val){
                // swap 
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                i++;
                j++;
            }
            else{
                j++;
            }
        }
        return i;
    }
}