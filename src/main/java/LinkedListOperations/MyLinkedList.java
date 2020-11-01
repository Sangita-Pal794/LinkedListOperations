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

        public void insert(MyNode myNode , MyNode newNode) {
            MyNode tempNode = myNode.getNext();  //store the latter node in tempNode
            myNode.setNext(newNode);            // make former node point to new node
            newNode.setNext(tempNode);          //make new node point to tempNode (containing latter node)
        }
        
        public MyNode pop() {
            MyNode tempNode = this.head;         //store head in tempNode
            this.head = head.getNext();         //set head to point to next node after head
            return tempNode;
        }
        
        public MyNode popLast(){
            MyNode tempNode = this.head;
            while (!tempNode.getNext().equals(tail)) {
                tempNode = tempNode.getNext();    //set tempNode to successive nodes
            }
            this.tail = tempNode;                //make tail store tempNode(which is storing last element before tail)
            tempNode = tempNode.getNext();       //make tempNode store tail
            return tempNode;
        }
        
        public boolean search(MyNode searchnode) {
            MyNode tempNode = this.head;
            while (tempNode != searchnode && tempNode.getNext() != this.tail){
                tempNode = tempNode.getNext();
            }
            if (tempNode == searchnode)
                return true;
            else
                return false;
        }
        
        public <E> MyNode index(E searchKey) {
            MyNode tempNode = this.head;
            while (tempNode.getKey() != searchKey) {
                tempNode = tempNode.getNext();
            }
            return tempNode;
        }
    }
