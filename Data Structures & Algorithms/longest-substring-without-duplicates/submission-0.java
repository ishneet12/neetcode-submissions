class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int maxlen = 0;
        int j = 0;
        for (int i = 0; i < s.length(); i++) {
            if(mp.containsKey(s.charAt(i))) {
                j = Math.max(mp.get(s.charAt(i)) + 1 , j);
            }
            mp.put(s.charAt(i), i);
            maxlen = Math.max(maxlen, i - j + 1);
        }
        return maxlen;
    }
}
