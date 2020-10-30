package LinkedListOperations;

public class INode<T> implements MyNode<T>{
	
	public T key;
    public MyNode next;

    public INode(T key) {
        this.key = key;
        this.next = null;
    }

  //implementation of methods from INode interface
    @Override
    public T getKey() {
        return key;
    }

    @Override
    public void setKey(T key) {
        this.key = key;
    }
    
    //getter and setter methods for next
    public INode getNext() {
        return next;
    }
    public void setNext(INode next) {
        this.next = next;
    }
}
