class Solution {
    public int countCharacters(String[] words, String chars) {
        HashMap<Character,Integer> st = new HashMap<>();

        for(int i=0;i<chars.length();i++){
            st.put(chars.charAt(i),st.getOrDefault(chars.charAt(i),0)+1);
        }
        int cnt = 0;

        for(String s : words){
            HashMap<Character,Integer> mp = new HashMap<>();
            boolean flag = true;
            for(char c : s.toCharArray()){
                mp.put(c,mp.getOrDefault(c,0)+1);
                if(mp.getOrDefault(c,0)>st.getOrDefault(c,0)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                cnt+=s.length();
            }
        }
        return cnt;
    }
}