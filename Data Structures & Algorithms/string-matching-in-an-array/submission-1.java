class Solution {
    public List<String> stringMatching(String[] words) {
        
        List<String> ans = new ArrayList<>();

        Arrays.sort(words , (a,b) -> a.length() - b.length());
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[j].contains(words[i])){
                    ans.add(words[i]);
                    break;
                }
            }
        }
        return ans;

    }
}