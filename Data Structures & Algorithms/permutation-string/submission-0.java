class Solution {
    public boolean isPermutation(String s1 , String s2){
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        return Arrays.equals(str1,str2);
    }
    public boolean checkInclusion(String s1, String s2) {

        int p = 0;

        while(p<=s2.length()-s1.length()){
            if(isPermutation(s1,s2.substring(p,p+s1.length()))){
                return true;
            }
            p++;
        }

        return false;
    }
}
