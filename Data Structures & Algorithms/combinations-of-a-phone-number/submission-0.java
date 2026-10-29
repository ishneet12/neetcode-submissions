class Solution {
    List<String> ans;
    public void find(String d, int idx, HashMap<Integer, String> mp, StringBuilder sb) {
        if (idx == d.length()) {
            ans.add(sb.toString());
            return;
        }

        String s = mp.get(d.charAt(idx) - '0');
        for (char c : s.toCharArray()) {
            sb.append(c);
            find(d, idx + 1, mp, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        HashMap<Integer, String> mp = new HashMap<>();
        ans = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return ans;
        }
        mp.put(2, "abc");
        mp.put(3, "def");
        mp.put(4, "ghi");
        mp.put(5, "jkl");
        mp.put(6, "mno");
        mp.put(7, "pqrs");
        mp.put(8, "tuv");
        mp.put(9, "wxyz");
        find(digits, 0, mp, new StringBuilder());
        return ans;
    }
}
