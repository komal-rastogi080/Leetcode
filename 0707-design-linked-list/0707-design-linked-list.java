class MyLinkedList {
    class Node{
        int val;
        Node next;
        Node(int val){ this.val = val; }
    };
    private Node head;
    private int size;
    public MyLinkedList() {
        head =new Node(0);
        size=0;
    }
    
    public int get(int index) {
        if(index<0 || index >= size) return -1;
        Node temp = head.next;
        while(index>0){
            temp = temp.next;
            index--;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
         addAtIndex(0,val);
    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    public void addAtIndex(int index, int val) {
        if(index>size) return;
        Node temp = head;
        while(index > 0){
            temp = temp.next;
            index--;
        }
        Node nn = new Node(val);
        nn.next = temp.next;
        temp.next = nn;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index<0 || index >= size) return;
        Node temp = head;
        while(index > 0){
            temp = temp.next;
            index--;
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