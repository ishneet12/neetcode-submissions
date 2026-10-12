class Solution {
    public int calPoints(String[] op) {
        Stack<Integer> st = new Stack<>();

        for(String it : op){
            if(it.equals("+")){
                int top = st.pop();
                int newTop = st.peek()+top;
                st.push(top);
                st.push(newTop);
            }
            else if(it.equals("D")){
                st.push(2*st.peek());
            }

            else if(it.equals("C")){
                st.pop();
            }

            else{
                st.push(Integer.parseInt(it));
            }
        }
        int sum = 0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }
}