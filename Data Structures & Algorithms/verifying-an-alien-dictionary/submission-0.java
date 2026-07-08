class Solution {
    public boolean isAlienSorted(String[] words, String order) {

        int arr[] = new int[26];

        for(int i=0;i<order.length();i++){
            arr[order.charAt(i)-'a'] = i;
        }

        for(int i=0;i<words.length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];

            for(int j=0;j<s1.length();j++){
                if(j==s2.length()) return false;

                if(s1.charAt(j)!=s2.charAt(j)){
                    if(arr[s1.charAt(j) - 'a'] > arr[s2.charAt(j) - 'a']){
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }
}