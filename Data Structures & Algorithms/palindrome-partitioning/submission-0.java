class Solution {
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    List<List<String>> ans;
    List<String> ls;
    public void check(int idx, String s) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(ls));
            return ;
        }

        for (int i = idx; i < s.length(); i++) {
            if (isPalindrome(s.substring(idx, i + 1))) {
                ls.add(s.substring(idx, i + 1));
                check(i + 1, s);
                ls.remove(ls.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();
        ls = new ArrayList<>();

        check(0, s);
        return ans;
    }
}
