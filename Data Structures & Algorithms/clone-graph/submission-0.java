/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        HashMap<Node,Node> mp = new HashMap<>();
        Queue<Node> qu = new LinkedList<>();
        mp.put(node,new Node(node.val));
        qu.offer(node);

        while(!qu.isEmpty()){
            Node cur = qu.poll();

            for(Node it : cur.neighbors){
                if(!mp.containsKey(it)){
                    mp.put(it,new Node(it.val));
                    qu.offer(it);
                }
                mp.get(cur).neighbors.add(mp.get(it));
            }
            
        }
        return mp.get(node);
    }
}