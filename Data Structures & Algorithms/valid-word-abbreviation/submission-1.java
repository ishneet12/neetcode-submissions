class Solution {
    public boolean validWordAbbreviation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int i=0;
        int j=0;

        while(i<n && j<m){

            if(Character.isLetter(s2.charAt(j))){
                if(i<n && s1.charAt(i)==s2.charAt(j)){
                    i++;
                    j++;
                }
                else{
                    return false;
                }
            }
            else{
                if(s2.charAt(j)=='0') return false;
                int len = 0;
                while(j<m && Character.isDigit(s2.charAt(j)) ){
                    len = len*10 + (s2.charAt(j)-'0');
                    j++;
                }
                i+=len;
            }
        }

        return i==n && j==m;
    }
}