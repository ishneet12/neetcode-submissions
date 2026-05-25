class Solution {
    public int countSeniors(String[] details) {
        int cnt= 0;
        for(String s : details){
            char a = s.charAt(11);
            char g = s.charAt(12);
            int num = Integer.parseInt("" + a + g);
            if(num>60){
                cnt++;
            }
        }
        return cnt;
    }
}