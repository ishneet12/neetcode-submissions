class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
class MyLinkedList {
    ListNode head;
    int size;
    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }
    
    public int get(int index) {
        if(index>=size){
            return -1;
        }
        ListNode temp = head.next;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode temp = new ListNode(val);
        temp.next = head.next;
        head.next = temp;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if(index==0){
            addAtHead(val);
            return;
        }
        ListNode temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        ListNode tempNew = new ListNode(val);
        tempNew.next = temp.next;
        temp.next = tempNew;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index>=size) return;

        ListNode temp = head;
        for(int i=0;i<index-1;i++){
            temp = temp.next;
        }

        temp.next = temp.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */