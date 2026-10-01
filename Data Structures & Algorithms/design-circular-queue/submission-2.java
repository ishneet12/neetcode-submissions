class MyCircularQueue {
    int arr[];
    int front;
    int rear;
    int size;
    int n ;
    public MyCircularQueue(int k) {
        arr = new int[k];
        front = -1;
        rear = -1;   
        size = 0 ;
        n = k;
    }
    public boolean enQueue(int val) {
        if(isFull()){
            return false;
        }

        if(front==-1){
            front = 0;
        }
        rear = (rear+1)%n;
        arr[rear] = val;
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(front==rear){
            front=-1;
            rear=-1;
        }
        else{
            front = (front+1)%n;
        }
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return arr[rear];
    }
    
    public boolean isEmpty() {
        return size==0;
    }
    
    public boolean isFull() {
        if(size==n){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */