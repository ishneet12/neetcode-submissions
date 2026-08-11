class Solution {
    public int countConsistentStrings(String a, String[] words) {
        HashSet<Character> st = new HashSet<>();

        for(int i=0;i<a.length();i++){
            st.add(a.charAt(i));
        }

        int cnt = 0;

        for(String s : words){
            boolean flag = true;
            for(char c : s.toCharArray()){
                if(!st.contains(c)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                cnt++;
            }
        }
        return cnt;
    }
}