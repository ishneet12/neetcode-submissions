class Solution {
    public int largestRectangleArea(int[] arr) {
        Stack<Integer> st = new Stack<>();
        int n = arr.length;
        int maxArea = 0;
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && (i==n || arr[st.peek()]>arr[i])){
                int ele = st.pop();
                int nse = i;
                int pse = st.isEmpty() ? -1 : st.peek();

                int area = arr[ele] * (nse-pse-1);
                maxArea = Math.max(area,maxArea);
            }
            st.push(i);
        }
        return maxArea;
    }
}
