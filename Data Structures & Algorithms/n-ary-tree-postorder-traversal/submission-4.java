/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
*/

class Solution {
    class pair{

        Node n ;
        Boolean bb;

        pair(Node x , Boolean y){
            n = x;
            bb = y;
        }
    }
    public List<Integer> postorder(Node root) {

        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;

        Stack<pair> st = new Stack<>();

        st.push(new pair(root,false));

        while(!st.isEmpty()){

            pair cur = st.pop();
            Node temp = cur.n;
            boolean vis = cur.bb;

            if(vis){
                ans.add(temp.val);
            }
            else{
                st.push(new pair(temp,true));
                for(int i=temp.children.size()-1;i>=0;i--){
                    if(temp.children.get(i)!=null){
                        st.push(new pair(temp.children.get(i),false));
                    }
                }  
            }
        }

       // Collections.reverse(ans);
        return ans;
    }
}