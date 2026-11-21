class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int idx[] = new int[26];

        for(int i=0;i<order.length();i++){
            char c = order.charAt(i);

            idx[c-'a'] = i;
        }

        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            
            for(int j=0;j<s1.length();j++){
                if(j==s2.length()){
                    return false;
                }

                if(s1.charAt(j)!= s2.charAt(j)){
                    if(idx[s1.charAt(j)-'a']> idx[s2.charAt(j)-'a']){
                        return false;
                    }
                    break;
                }
                
            }
        }
        return true;
    }
}