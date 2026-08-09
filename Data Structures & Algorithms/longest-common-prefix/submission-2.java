class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();

        int n = strs.length;
        int maxlen = strs[0].length();

        for (int i = 0; i < strs.length; i++) {

            int j = 0;

            while (j < maxlen && j < strs[i].length() && strs[0].charAt(j) == strs[i].charAt(j)){
                j++;
                
            } 
            maxlen = j;

            if(maxlen==0){
                return "";
            }
        }

        return strs[0].substring(0, maxlen);
    }
}