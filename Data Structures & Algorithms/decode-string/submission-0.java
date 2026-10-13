class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if (s.charAt(i) != ']') {
                st.push(String.valueOf(s.charAt(i)));
            } 

            else{
                StringBuilder sb = new StringBuilder();

                while(!st.isEmpty() && !st.peek().equals("[")){
                    sb.insert(0,st.pop());
                }
                st.pop();
                
                StringBuilder k = new StringBuilder();

                while(!st.isEmpty() && Character.isDigit(st.peek().charAt(0))){
                    k.insert(0,st.pop());
                }

                int cnt = Integer.parseInt(k.toString());

                String repeatedString = sb.toString().repeat(cnt);

                st.push(repeatedString);
            }
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.insert(0,st.pop());
        }
        return sb.toString();
    }
}