class Solution {
    public boolean wordPattern(String p, String s) {
        String arr[] = s.split(" ");

        HashMap<String , Character> wtc = new HashMap<>();
        HashMap<Character,String> ctw = new HashMap<>();

        if(arr.length != p.length()) return false;

        for(int i=0;i<p.length();i++){
            Character c = p.charAt(i);
            String w = arr[i];

            if(ctw.containsKey(c) && !ctw.get(c).equals(w)){
                return false;
            }
            if(wtc.containsKey(w) && wtc.get(w)!=c){
                return false;
            }

            wtc.put(w,c);
            ctw.put(c,w);
        }

        return true; 
    }
}