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
        Node temp;
        Boolean vis;
        pair(Node x , Boolean y){
            temp = x;
            vis = y;
        }
    }
    public List<Integer> postorder(Node root) {
       Stack<pair> st = new Stack<>();
       List<Integer> ls = new ArrayList<>();

        if (root == null) return ls;
       st.push(new pair(root,false));

       while(!st.isEmpty()){
        pair cur = st.pop();
        Node temp = cur.temp;
        Boolean vis = cur.vis;

        if(vis){
            ls.add(temp.val);
        }
        else{
            st.push(new pair(temp,true));

            for(int i=temp.children.size()-1;i>=0;i--){
                st.push(new pair(temp.children.get(i),false));
            }
        }
       }
       return ls;
    }
}