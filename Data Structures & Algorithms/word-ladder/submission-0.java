class Solution {
    class pair{
        String s;
        int cnt;

        pair(String x , int y){
            s = x;
            cnt = y;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        HashSet<String> st = new HashSet<>(wordList);

        if(!st.contains(endWord)) return 0;

        Queue<pair> qu = new LinkedList<>();
        qu.offer(new pair(beginWord,1));
        st.remove(beginWord);

        while(!qu.isEmpty()){
            pair cur = qu.poll();
            int c = cur.cnt;
            String s = cur.s;

            if(s.equals(endWord)){
                return c;
            }
            char arr[] = s.toCharArray();
            for(int i=0;i<arr.length;i++){
                char temp = arr[i];
                for(char j='a';j<='z';j++){
                    arr[i] = j;
                    String str = new String(arr);
                    if(st.contains(str)){
                        qu.offer(new pair(str,c+1));
                        st.remove(str);
                    }
                }
                arr[i] = temp;
            }
        }

        return 0;
    }
}
