class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> mp = new HashMap<>();

        int j=0;
        int maxlen = 0;
        int maxfreq = 0;
        for(int i=0;i<s.length();i++){
            mp.put(s.charAt(i) , mp.getOrDefault(s.charAt(i) , 0) + 1);
            maxfreq = Math.max(mp.get(s.charAt(i)) , maxfreq);

            while((i-j+1) - maxfreq > k){
                mp.put(s.charAt(j) , mp.getOrDefault(s.charAt(j) , 0) - 1);
                j++;
            }

            maxlen = Math.max(i-j+1 , maxlen);
        }
        return maxlen;
    }
}
