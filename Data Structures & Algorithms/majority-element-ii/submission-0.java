class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int ele1 = -1 , cnt1 = 0;
        int ele2 = -1 , cnt2 = 0;

        for(int it : nums){
            if(cnt1==0 && ele2!=it){
                ele1 = it;
                cnt1++;
            }

            else if(cnt2==0 && ele1!=it){
                ele2 = it;
                cnt2++;
            }

            else if(ele1==it){
                cnt1++;
            }
            else if(ele2==it){
                cnt2++;
            }

            else{
                cnt1--;
                cnt2--;
            }
        } 

        int len = nums.length/3;

        cnt1 = 0;
        cnt2 = 0;

        for(int it : nums){
            if(it==ele1){
                cnt1++;
            }
            else if(it==ele2){
                cnt2++;
            }
        }

        List<Integer> ans = new ArrayList<>();

        if(cnt1>len){
            ans.add(ele1);
        }

        if(cnt2>len){
            ans.add(ele2);
        }

        return ans;
        
    }
}