class Solution {
    public int compress(char[] chars) {
        int n = chars.length;

        int i=0, k=0;

        while(i<n){
            chars[k]=chars[i];
            int j=i+1;
            k++;

            while(j<n && chars[i]==chars[j]){
                j++;
            }

            if(j-i>1){
                String cnt = String.valueOf(j-i);
                for(char c : cnt.toCharArray()){
                    chars[k]=c;
                    k++;
                }
            }
            i=j;
        }
        return k;
    }
}