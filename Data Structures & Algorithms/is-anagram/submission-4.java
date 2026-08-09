class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()>t.length() || s.length()<t.length()) return false;

        char arr[] = new char[26];

        for(int i=0;i<Math.max(s.length(),t.length());i++){
           arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int ch : arr){
            if(ch!=0){
                return false;
            }
        }

        return true;
    }
}
