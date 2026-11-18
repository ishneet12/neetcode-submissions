class FreqStack {
    HashMap<Integer,Integer> mp;
    Map<Integer,Stack<Integer>> ls;
    int maxfreq ;
    public FreqStack() {
        mp = new HashMap<>();
        ls = new HashMap<>();
        maxfreq = 0;
    }
    
    public void push(int val) {
        int f = mp.getOrDefault(val,0)+1;
        mp.put(val,f);
        maxfreq = Math.max(maxfreq,f);

        if(!ls.containsKey(f)){
            ls.put(f,new Stack<>());
        }

        ls.get(f).push(val);
    }
    
    public int pop() {
        Stack<Integer> st = ls.get(maxfreq);
        int ele = st.pop();

        if(st.isEmpty()){
            maxfreq--;
        }

        mp.put(ele,mp.get(ele)-1);
        return ele;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */