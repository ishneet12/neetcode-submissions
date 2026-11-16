class Solution {
    class pair {
        int freq;
        int time;

        pair(int x, int y) {
            freq = x;
            time = y;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> mp = new HashMap<>();

        for (char c : tasks) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        Queue<pair> qu = new LinkedList<>();
        pq.addAll(mp.values());
        int time = 0;
        while (!pq.isEmpty() || !qu.isEmpty()) {
            time++;
            if (!pq.isEmpty()) {
                int cur = pq.poll()-1;
                int t = time + n;

                if(cur!=0){
                    qu.offer(new pair(cur, t));
                }
                
            }

            if(!qu.isEmpty() && qu.peek().time==time){
                pq.offer(qu.poll().freq);
            }

        }

        return time;
    }
}
