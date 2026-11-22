class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> qu = new LinkedList<>();
        Set<String> st = new HashSet<>();

        st.addAll(Arrays.asList(deadends));

        if (st.contains("0000")) {
            return -1;
        }

        qu.offer("0000");
        st.add("0000");

        int ans = 0;

        while (!qu.isEmpty()) {
            int size = qu.size();

            for (int i = 0; i < size; i++) {
                String s = qu.poll();
                if (s.equals(target)) {
                    return ans;
                }
                for (String it : children(s)) {
                    if (!st.contains(it)) {
                        qu.offer(it);
                        st.add(it);
                    }
                }
            }
            ans++;
        }
        return -1;

    }
     public List<String> children(String a){
        List<String> ans = new ArrayList<>();
        

        for(int i=0;i<4;i++){
            char arr[] = a.toCharArray();

            arr[i] = (char) (((arr[i]-'0' + 1)%10)+'0');
            ans.add(new String(arr));

            arr = a.toCharArray();

            arr[i] = (char) (((arr[i]-'0' - 1 + 10)%10)+'0');
            ans.add(new String(arr));

        }
        return ans;
    }
}
