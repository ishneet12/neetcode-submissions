class Solution {
    class pair {
        Character c;
        int freq;

        pair(char x, int y) {
            c = x;
            freq = y;
        }
    }
    public String reorganizeString(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();

        int n = s.length();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);

        for (Map.Entry<Character, Integer> it : mp.entrySet()) {
            pq.offer(new pair(it.getKey(), it.getValue()));
        }

        pair prev = null;

        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty() || prev != null) {
            if (prev != null && pq.isEmpty()) {
                return "";
            }

            pair cur = pq.poll();
            sb.append(cur.c);
            cur.freq--;

            if (prev != null) {
                pq.offer(prev);
                prev = null;
            }

            if (cur.freq > 0) {
                prev = cur;
            }
        }

        return sb.toString();
    }
}