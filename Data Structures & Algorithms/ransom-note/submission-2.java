class Solution {
    public boolean canConstruct(String s, String t) {
        List<Character> ls = new ArrayList<>();
        for(char c : t.toCharArray()){
            ls.add(c);
        }

        for(char c : s.toCharArray()){
            if(!ls.contains(c)){
                return false;
            }
            ls.remove((Character) c);
        }
        return true;
    }
}