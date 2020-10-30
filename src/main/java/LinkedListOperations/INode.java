package LinkedListOperations;

public class INode<T> {
	
	private T key;
    private INode next;

    public INode(T key) {
        this.key = key;
        this.next = null;
    }

    //getter and setter methods for next
    public INode getNext() {
        return next;
    }
    public void setNext(INode next) {
        this.next = next;
    }
}
