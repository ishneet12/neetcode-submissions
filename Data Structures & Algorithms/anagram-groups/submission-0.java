class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String,List<String>> mp = new HashMap<>();

        for(String s : strs){
            char arr[] = s.toCharArray();
            Arrays.sort(arr);
            String st = new String(arr);
            mp.putIfAbsent(st,new ArrayList<>());
            mp.get(st).add(s);
        }

        return new ArrayList<>(mp.values());


    }
}
