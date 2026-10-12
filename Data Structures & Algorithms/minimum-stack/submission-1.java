class MinStack {
    Stack<Long> st;
    long min;
    public MinStack() {
        st = new Stack<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        if (st.isEmpty()) {
            st.push((long) val);
            min = val;
        } else if (val >= min) {
            st.push((long) val);
        } else {
            long newVal = 2L * val - min;
            st.push(newVal);
            min = val;
        }
    }

    public void pop() {
        if (st.isEmpty()) {
            return;
        } else if (st.peek() > min) {
            st.pop();
        } else {
            long val = st.pop();
            min = 2L * min - val;
        }
    }

    public int top() {
        if (st.isEmpty()) {
            return -1;
        }
        long val = st.peek();

        if (val < min) {
            return (int) min;
        }

        return (int) val;
    }

    public int getMin() {
        return (int) min;
    }
}
