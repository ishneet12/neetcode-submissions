class Solution {
    public int minimumRecolors(String s, int k) {
        int cnt = 0;
        
        for(int i=0;i<k;i++){
            if(s.charAt(i)=='W'){
                cnt++;
            }
        }
        int minCnt = cnt;
        for(int i=k;i<s.length();i++){
            if(s.charAt(i-k)=='W'){
                cnt--;
            }
            if(s.charAt(i)=='W'){
                cnt++;
            }

            minCnt = Math.min(minCnt,cnt);
        }

        return minCnt;
    }
}