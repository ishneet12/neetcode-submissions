class Solution {
    public String foreignDictionary(String[] words) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        int n = words.length;

        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }

        int indegree[] = new int[26];
        int exist[] = new int[26];

        for (String s : words) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                exist[c - 'a'] = 1;
            }
        }

        for (int i = 0; i < n - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];

            int len = Math.min(s1.length(), s2.length());

            int j = 0;
            while (j < len && s1.charAt(j) == s2.charAt(j)) {
                j++;
            }

            if (j < len) {
                int u = s1.charAt(j) - 'a';
                int v = s2.charAt(j) - 'a';

                adj.get(u).add(v);
                indegree[v]++;
            } else if (s1.length() > s2.length()) {
                return "";
            }
        }

        Queue<Integer> qu = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (exist[i] == 1 && indegree[i] == 0) {
                qu.offer(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!qu.isEmpty()) {
            int p = qu.poll() ;
            char c = (char) (p + 'a');
            sb.append(c);

            for (int it : adj.get(p)) {
                indegree[it]--;

                if (exist[it] == 1 && indegree[it] == 0) {
                    qu.offer(it);
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 26; i++) {
            if (exist[i] == 1) {
                cnt++;
            }
        }
        if(sb.length()!=cnt){
            return "";
        }
        return sb.toString();
    }
}
