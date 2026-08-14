class Solution {
    public String mergeAlternately(String s1, String s2) {
        StringBuilder sb  = new StringBuilder();

        int i=0 , j=0;

        int n = s1.length();
        int m = s2.length();

        while(i<n && j<m){
            sb.append(s1.charAt(i));
            sb.append(s2.charAt(j));
            i++;
            j++;
        }

        while(i<n){
            sb.append(s1.charAt(i));
            i++;
        }
        while(j<m){
            sb.append(s2.charAt(j));
            j++;
        }
        return sb.toString();
    }
}