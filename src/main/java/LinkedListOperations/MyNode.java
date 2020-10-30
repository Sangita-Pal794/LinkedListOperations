package LinkedListOperations;

public interface MyNode<T> {

	T getKey();
    void setKey(T key);

    MyNode getNext();
    void setNext(MyNode next);
}
