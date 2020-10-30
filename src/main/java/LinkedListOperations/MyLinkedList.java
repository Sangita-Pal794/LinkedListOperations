package LinkedListOperations;

public class MyLinkedList {

	public MyNode tail;
    public MyNode head;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(MyNode newNode) {
        if(this.head == null && this.tail == null) {
            this.head = newNode;
            this.tail = newNode;
        }
        else {
            
        	//already present node to which head pointed is now in tempNode
        	MyNode tempNode = this.head; 
        	//make head point to the new node
        	this.head = newNode;        
        	// node next to node being pointed by head is set to the old node
        	this.head.setNext(tempNode);
        }
       }

        public void append(MyNode newNode) {
            if(this.head == null && this.tail == null) {
                this.head = newNode;
                this.tail = newNode;
            }
            else {
                this.tail.setNext(newNode);
                this.tail = newNode;
            }
    }
}
