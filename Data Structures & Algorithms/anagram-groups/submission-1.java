class Solution {
   
    public List<List<String>> groupAnagrams(String[] strs) {
      
        HashMap<String , List<String>> mp = new HashMap<>();

        int n = strs.length;

        for (String s : strs) {

            char arr[] = s.toCharArray();

            Arrays.sort(arr);

            String st = new String(arr);

            if(!mp.containsKey(st)){
                mp.put(st,new ArrayList<>());
            }

            mp.get(st).add(s);

        }
        return new ArrayList<>(mp.values());
    }
}
