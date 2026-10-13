class StockSpanner {
    Stack<Integer> st ;
    ArrayList<Integer> arr;
    public StockSpanner() {
        st = new Stack<>();
        arr = new ArrayList<>();
    }
    
    public int next(int p) {
        arr.add(p);

        while(!st.isEmpty() && arr.get(st.peek())<=p){
            st.pop();
        }

        int pge = st.isEmpty() ? -1 : st.peek();

        int ans = arr.size()-1-pge ;

        st.push(arr.size()-1);
        
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */