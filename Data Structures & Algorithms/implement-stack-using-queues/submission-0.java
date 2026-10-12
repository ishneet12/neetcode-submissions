class MyStack {
    Queue<Integer> qu ;
    public MyStack() {
        qu = new LinkedList<>();
    }
    
    public void push(int x) {
        qu.offer(x);
        int n = qu.size();
        for(int i=0;i<n-1;i++){
            qu.offer(qu.poll());
        }
    }
    
    public int pop() {
       return qu.poll();
    }
    
    public int top() {
        return qu.peek();
    }
    
    public boolean empty() {
        return qu.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */