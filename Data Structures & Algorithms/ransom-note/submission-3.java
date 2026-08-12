class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        List<Character> s = new ArrayList<>();

        for(Character c : magazine.toCharArray()){
            s.add(c);
        }

        for(Character c : ransomNote.toCharArray()){
            if(!s.contains(c)) return false;

            s.remove(c);
        }
        return true;
    }
}