class Solution {
    class pair {
        char c;
        int freq;

        pair(char x, int y) {
            c = x;
            freq = y;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<pair> pq = new PriorityQueue<>((x, y) -> y.freq - x.freq);

        StringBuilder sb = new StringBuilder();
        if(a>0){
            pq.offer(new pair('a',a));
        }
        if(b>0){
            pq.offer(new pair('b',b));
        }

        if(c>0){
            pq.offer(new pair('c',c));
        }
       


        while(!pq.isEmpty()){
            pair f = pq.poll();

            if(sb.length()>1 && sb.charAt(sb.length()-1)==f.c && sb.charAt(sb.length()-2)==f.c){
                if(pq.isEmpty()){
                    break;
                }
                pair sec = pq.poll();

                sb.append(sec.c);
                sec.freq--;
                
                if(sec.freq>0){
                    pq.offer(sec);
                }
                pq.offer(f);
            }
            else{
                sb.append(f.c);
                f.freq--;
                
                if(f.freq>0){
                    pq.offer(f);
                }
            }
        }
        return sb.toString();
    }
}